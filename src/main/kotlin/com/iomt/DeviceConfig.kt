package com.iomt

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class DeviceConfig(
    val id: Long,
    val general: General,
    val characteristics: Map<String, Characteristic>,
) {
    @Serializable
    data class General(
        val name: String,
        @SerialName("name_regex") val nameRegex: String,
        val type: String,
    )

    @Serializable
    data class Characteristic(
        val name: String,
        @SerialName("service_uuid") val serviceUuid: String,
        @SerialName("characteristic_uuid") val characteristicUuid: String,
    ) {
        companion object {
            val heartRate = Characteristic(
                "Heart Rate",
                "0000180d-0000-1000-8000-00805f9b34fb",
                "00002a37-0000-1000-8000-00805f9b34fb",
            )

            val respirationRate = Characteristic(
                "Respiration Rate",
                "3b55c581-bc19-48f0-bd8c-b522796f8e24",
                "9bc730c3-8cc0-4d87-85bc-573d6304403c",
            )

            val accelerometerRate = Characteristic(
                "Accelerometer Rate",
                "bdc750c7-2649-4fa8-abe8-fbf25038cda3",
                "75246a26-237a-4863-aca6-09b639344f43",
            )
        }
    }

    companion object {
        val hexoskin = DeviceConfig(
            id = 1,
            general = General("Hexoskin", "Hexoskin", "vest"),
            characteristics = mapOf(
                "heartRate" to Characteristic.heartRate,
                "respirationRate" to Characteristic.respirationRate,
                "accelerometerRate" to Characteristic.accelerometerRate,
            ),
        )

        val miBand = DeviceConfig(
            id = 2,
            general = General("Mi Band", "Mi Band", "band"),
            characteristics = mapOf("heartRate" to Characteristic.heartRate),
        )

        val deviceConfigs = listOf(hexoskin, miBand)
    }
}