import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable

import java.util.Calendar

@Parcelize
@Serializable
data class Clock(
    val id: Int,
    val time: String,
    val local: String,
    val type: TypeClock,
    val desc: String? = null
): Parcelable

enum class TypeClock {
    CLOCKIN, CLOCKOUT
}