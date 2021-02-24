package ru.torear.resume

data class User(
    var id: Int? = null,
    var first_name: String? = "",
    var surname: String? = "",
    var patronymic: String? = "",
    var phone: String? = "",
    var email: String? = "",
    var role: List<Role>? = null,
    var regions: Map<Int, String>? = null,
    var create_date: String? = "",
) {
    fun getInitials(): String =
        (first_name?.get(0) ?: "0").toString() + (surname?.get(0) ?: "0").toString()

    fun getRegionString(): String {
        var regionsString = ""
        regions?.forEach {
            if (regionsString.isNotEmpty()) regionsString += ", "
            regionsString += it.value
        }
        return regionsString
    }

    fun getRoleString(): String {
        var resault = ""

        val iterator = role?.toList()?.iterator()

        iterator?.forEach { role ->

            if (resault.isNotEmpty()) resault += ", "
            resault += role.description
        }

        return resault
    }

    fun getRolesIds(): List<Int> {
        val arrayRoles: MutableList<Int> = mutableListOf()

        role?.forEach {
            it.id?.let { it1 -> arrayRoles.add(it1) }
        }

        return arrayRoles
    }

    fun getRolesArrayName(): List<String> {
        val arrayRoles: MutableList<String> = mutableListOf()

        role?.forEach {
            it.name?.let { it1 -> arrayRoles.add(it1) }
        }

        return arrayRoles
    }
}