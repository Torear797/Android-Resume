package ru.torear.resume

data class User(
    val id: Int,
    val first_name: String,
    val surname: String,
    val patronymic: String,
    val phone: String,
    val email: String,
    val role: List<Role>,
    val regions: Map<Int, String>,
    val create_date: String,
) {
    fun getInitials(): String =
        first_name[0].toString() + surname[0].toString()

    fun getRegionString(): String {
        var regionsString = ""
        regions.forEach {
            if (regionsString.isNotEmpty()) regionsString += ", "
            regionsString += it.value
        }
        return regionsString
    }

    fun getRoleString(): String {
        var resault = ""

        val iterator = role.toList().iterator()

        iterator.forEach { role ->

            if (resault.isNotEmpty()) resault += ", "
            resault += role.description
        }

        return resault
    }

    fun getRolesIds(): List<Int> {
        val arrayRoles: MutableList<Int> = mutableListOf()

        role.forEach {
            it.id.let { it1 -> arrayRoles.add(it1) }
        }

        return arrayRoles
    }

    fun getRolesArrayName(): List<String> {
        val arrayRoles: MutableList<String> = mutableListOf()

        role.forEach {
            it.name.let { it1 -> arrayRoles.add(it1) }
        }

        return arrayRoles
    }
}