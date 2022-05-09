package racingcar.utils

import racingcar.ui.getRoundByUser
import racingcar.ui.printErrorMessage

private const val INVALID_ROUND_ERROR_MESSAGE = "자연수로 입력해 주세요."
private val POSITIVE_INTEGER_REGEX = Regex("^([1-9][0-9]*)$")

fun getRoundInput(): Int {
    val userInput = getRoundByUser()
    return try {
        validateRoundNumber(userInput)
        Integer.parseInt(userInput)
    } catch (e: IllegalArgumentException) {
        printErrorMessage(e.message)
        return getRoundInput()
    }
}

fun validateRoundNumber(round: String?) {
    require(isPositiveNumber(round)) { INVALID_ROUND_ERROR_MESSAGE }
}

fun isPositiveNumber(round: String?): Boolean {
    return round!!.matches(POSITIVE_INTEGER_REGEX)
}
