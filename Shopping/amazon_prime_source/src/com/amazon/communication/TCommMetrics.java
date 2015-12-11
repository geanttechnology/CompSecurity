// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.communication;


public final class TCommMetrics
{

    public static final String COUNT_ACQUIRE_PROTOCOL_SOCKETS_NEW = "CountAcquireProtocolSocketsNew";
    public static final String COUNT_ACQUIRE_PROTOCOL_SOCKETS_REUSED = "CountAcquireProtocolSocketsReused";
    public static final String COUNT_ACQUIRE_PROTOCOL_SOCKETS_THROUGH_GATEWAY = "CountAcquireProtocolSocketsThroughGateway";
    public static final String COUNT_ACQUIRE_PROTOCOL_SOCKETS_TOTAL = "CountAcquireProtocolSocketsTotal";
    public static final String COUNT_BYTES_DECRYPTED = "CountBytesDecrypted";
    public static final String COUNT_BYTES_ENCRYPTED = "CountBytesEncrypted";
    public static final String COUNT_CHAIN_HANDLED_ON_LARGE_MESSAGE = "CountChainHandledOnLargeMessage";
    public static final String COUNT_CHAIN_HANDLED_ON_SIMPLE_MESSAGE = "CountChainHandledOnSimpleMessage";
    public static final String COUNT_CHAIN_HANDLED_ON_TUNING_MESSAGE = "CountChainHandledOnTuningMessage";
    public static final String COUNT_CHAIN_REJECTED_ON_LARGE_MESSAGE = "CountChainRejectedOnLargeMessage";
    public static final String COUNT_CHAIN_REJECTED_ON_SIMPLE_MESSAGE = "CountChainRejectedOnSimpleMessage";
    public static final String COUNT_CLOSE_SOCKET_CHANNEL_CODE = "CountCloseSocketChannelCode";
    public static final String COUNT_CLOSE_SOCKET_CHANNEL_REASON = "CountCloseSocketChannelReason";
    public static final String COUNT_COMPRESSED_BYTES = "CountCompressedBytes";
    public static final String COUNT_CONNECTING_SOCKET_CLOSE_NORMAL = "CountConnectingSocketCloseNormal";
    public static final String COUNT_CONNECTING_SOCKET_UNEXPECTED_CLOSE = "CountConnectingSocketUnexpectedClose";
    public static final String COUNT_CONNECTIVITY = "CountConnectivity";
    public static final String COUNT_D2D_MESSAGE_AS_INTENT = "CountD2DMessageAsIntent";
    public static final String COUNT_DEVICE_WOKEN_UP_FOR_HEARTBEATS = "CountDeviceWakeupsForHeartbeat";
    public static final String COUNT_DIRECTBIDISOCKET_CONNECTION_ESTABLISHED = "CountDirectBidiSocketConnectionEstablished";
    public static final String COUNT_DIRECT_BI_DI_SOCKET_CONNECTION_RESET = "CountDirectBiDiSocketConnectionReset";
    public static final String COUNT_DIRECT_BI_DI_SOCKET_USED = "CountDirectBiDiSocketUsed";
    public static final String COUNT_ENCODE_MESSAGE = "CountEncodeMessage";
    public static final String COUNT_ENCODE_TUNING_MESSAGE = "CountEncodeTuningMessage";
    public static final String COUNT_ENDPOINT_RESOLUTIONS_FAILURE = "CountEndpointResolutionsFailure";
    public static final String COUNT_ENDPOINT_RESOLUTIONS_SUCCESS = "CountEndpointResolutionsSuccess";
    public static final String COUNT_ENDPOINT_RESOLUTIONS_TOTAL = "CountEndpointResolutionsTotal";
    public static final String COUNT_ESTABLISHED_SOCKET_CLOSE_NORMAL = "CountEstablishedSocketCloseNormal";
    public static final String COUNT_ESTABLISHED_SOCKET_UNEXPECTED_CLOSE = "CountEstablishedSocketUnexpectedClose";
    public static final String COUNT_ESTABLISH_NEW_CONNECTION_SUCCESS = "CountEstablishNewConnectionSuccess";
    public static final String COUNT_ESTABLISH_NEW_CONNECTION_TIMEOUT = "CountEstablishNewConnectionTimeout";
    public static final String COUNT_ESTABLISH_NEW_CONNECTION_TOTAL = "CountEstablishNewConnectionTotal";
    public static final String COUNT_HEARTBEATS_NOT_SENT_IN_TIME = "CountHeartbeatsNotSentInTime";
    public static final String COUNT_HEARTBEATS_NO_RESPONSE_RECEIVED = "CountHeartbeatsNoResponseReceived";
    public static final String COUNT_HEARTBEATS_SCHEDULED_GAVE_UP = "CountHeartbeatsScheduledGaveUp";
    public static final String COUNT_HEARTBEATS_SCHEDULED_UNHANDLED_EXCEPTION = "CountHeartbeatsScheduledUnhandledException";
    public static final String COUNT_HEARTBEATS_SENT_SUCCESS = "CountHeartbeatsSentSuccess";
    public static final String COUNT_HEARTBEATS_SENT_TOTAL = "CountHeartbeatsSentTotal";
    public static final String COUNT_HEARTBEATS_SENT_UNHANDLED_EXCEPTION = "CountHeartbeatsSentUnhandledException";
    public static final String COUNT_HEARTBEATS_STALE_CHECKS_NO_MATCHING_SOCKET = "CountHeartbeatsStaleChecksNoMatchingSocket";
    public static final String COUNT_HEARTBEATS_STALE_CHECKS_TOTAL = "CountHeartbeatsStaleChecksTotal";
    public static final String COUNT_KEEP_ALIVE_FAILURE = "CountTcpKeepAliveCheckerFailure";
    public static final String COUNT_KEEP_ALIVE_SUCCESS = "CountTcpKeepAliveCheckerSuccess";
    public static final String COUNT_MESSAGE_DROPPED_NO_LISTENER = "CountMessageDroppedNoListener";
    public static final String COUNT_NO_CONNECTIVITY = "CountNoConnectivity";
    public static final String COUNT_NUMBER_MESSAGES_DROPPED = "CountNumberMessagesDropped";
    public static final String COUNT_ON_BYTE_BUFFER_CHAIN_QUEUED_USED = "CountOnByteBufferChainQueuedUsed";
    public static final String COUNT_ON_BYTE_BUFFER_CHAIN_WEB_SOCKET_CLIENT_USED = "CountOnByteBufferChainWebSocketClientUsed";
    public static final String COUNT_PAYLOAD_SIZE_LARGE = "CountPayloadSizeLarge";
    public static final String COUNT_PAYLOAD_SIZE_SMALL = "CountPayloadSizeSmall";
    public static final String COUNT_PAYLOAD_SIZE_UNKNOWN = "CountPayloadSizeUnknown";
    public static final String COUNT_RAWHTTPSOCKET_CLOSED = "CountRawHttpSocketClosed";
    public static final String COUNT_RAWHTTPSOCKET_CONNECTION_ESTABLISHED = "CountRawHttpSocketConnectionEstablished";
    public static final String COUNT_RAW_HTTP_SOCKET_USED = "CountRawHttpSocketUsed";
    public static final String COUNT_RECEIVED_ACKS_TOTAL = "CountReceivedAcksTotal";
    public static final String COUNT_RECEIVED_NACKS_TOTAL = "CountReceivedNacksTotal";
    public static final String COUNT_RECEIVED_PACKS_TOTAL = "CountReceivedPacksTotal";
    public static final String COUNT_RECEIVED_RLM_ON_INCORRECT_CHANNEL = "CountReceivedRlmOnIncorrectChannel";
    public static final String COUNT_RECEIVED_RLM_RESPONSES_ON_INCORRECT_CHANNEL = "CountReceivedRlmResponsesOnIncorrectChannel";
    public static final String COUNT_RESUBMIT_SIMPLE_MESSAGE = "CountResubmitSimpleMessage";
    public static final String COUNT_RESUBMIT_SIMPLE_MESSAGE_FAILED = "CountResubmitSimpleMessageFailed";
    public static final String COUNT_RETRANSMIT_FRAGMENT = "CountRetransmitFragment";
    public static final String COUNT_SEND_MESSAGE_DATAPOINTS = "CountSendMessageDataPoints";
    public static final String COUNT_SEND_MESSAGE_SERVICE_SIDE_FAILURE = "CountSendMessageServiceSideFailure";
    public static final String COUNT_SEND_MESSAGE_SERVICE_SIDE_SUCCESS = "CountSendMessageServiceSideSuccess";
    public static final String COUNT_SEND_MESSAGE_SERVICE_SIDE_TOTAL = "CountSendMessageServiceSideTotal";
    public static final String COUNT_SEND_RELIABLE_MESSAGE_DATAPOINTS = "CountSendReliableMessageDataPoints";
    public static final String COUNT_SEND_RELIABLE_MESSAGE_SERVICE_SIDE_FAILURE = "CountSendReliableMessageServiceSideFailure";
    public static final String COUNT_SEND_RELIABLE_MESSAGE_SERVICE_SIDE_SUCCESS = "CountSendReliableMessageServiceSideSuccess";
    public static final String COUNT_SEND_RELIABLE_MESSAGE_SERVICE_SIDE_TOTAL = "CountSendReliableMessageServiceSideTotal";
    public static final String COUNT_SEND_REQUEST_DATAPOINTS = "CountSendRequestDataPoints";
    public static final String COUNT_SEND_REQUEST_SERVICE_SIDE_FAILURE = "CountSendRequestServiceSideFailure";
    public static final String COUNT_SEND_REQUEST_SERVICE_SIDE_SUCCESS = "CountSendRequestServiceSideSuccess";
    public static final String COUNT_SEND_REQUEST_SERVICE_SIDE_TOTAL = "CountSendRequestServiceSideTotal";
    public static final String COUNT_SENT_ACKS_TOTAL = "CountSentAcksTotal";
    public static final String COUNT_SENT_NACKS_TOTAL = "CountSentNacksTotal";
    public static final String COUNT_SENT_PACKS_TOTAL = "CountSentPacksTotal";
    public static final String COUNT_SIMPLE_MESSAGE_SIZE_IS_ZERO = "CountSimpleMessageSizeIsZero";
    public static final String COUNT_SIZE_MESSAGE_QUEUE = "CountSizeMessageQueue";
    public static final String COUNT_SIZE_PAYLOAD = "CountSizePayload";
    public static final String COUNT_SOCKET_NOT_STALE = "CountSocketNotStale";
    public static final String COUNT_SOCKET_ON_CLOSED_CODE = "CountSocketOnClosedCode";
    public static final String COUNT_SOCKET_ON_CLOSED_REASON = "CountSocketOnClosedReason";
    public static final String COUNT_SOCKET_RELEASED_BUT_REUSED = "CountSocketReleasedButReused";
    public static final String COUNT_SOCKET_RELEASED_TOTAL = "CountSocketReleasedTotal";
    public static final String COUNT_SRR_SERVICE_SIDE_FAILURE = "CountSrrServiceSideFailure";
    public static final String COUNT_SRR_SERVICE_SIDE_SUCCESS = "CountSrrServiceSideSuccess";
    public static final String COUNT_SRR_SERVICE_SIDE_TOTAL = "CountSrrServiceSideTotal";
    public static final String COUNT_SWITCHED_TO_LEARNING_MODE = "CountSwitchedToLearningMode";
    public static final String COUNT_TIMES_MESSAGES_DROPPED = "CountTimesMessagesDropped";
    public static final String COUNT_TIMES_MESSAGE_QUEUE_FULL = "CountMessageQueueFull";
    public static final String COUNT_TOTAL_RX_ACCOUNTED_BYTES = "CountTotalRxAccountedBytes";
    public static final String COUNT_TOTAL_RX_BYTES = "CountTotalRxBytes";
    public static final String COUNT_TOTAL_RX_REJECTED_BYTES = "CountTotalRxRejectedBytes";
    public static final String COUNT_TOTAL_RX_UNACCOUNTED_BYTES = "CountTotalRxUnaccountedBytes";
    public static final String COUNT_TOTAL_TX_ACCOUNTED_BYTES = "CountTotalTxAccountedBytes";
    public static final String COUNT_TOTAL_TX_ACCOUNTED_BYTES_RAW_HTTP_SOCKET = "CountTotalTxAccountedBytesRawHttpSocket";
    public static final String COUNT_TOTAL_TX_BYTES = "CountTotalTxBytes";
    public static final String COUNT_TOTAL_TX_MISACCOUNTED_BYTES_RAW_HTTP_SOCKET = "CountTotalTxMisaccountedBytesRawHttpSocket";
    public static final String COUNT_TOTAL_TX_REJECTED_BYTES = "CountTotalTxRejectedBytes";
    public static final String COUNT_TRANSMIT_FRAGMENT = "CountTransmitFragment";
    public static final String COUNT_UITHREAD_INVOCATION = "CountUIThreadInvocation";
    public static final String COUNT_UNCOMPRESSED_BYTES = "CountUncompressedBytes";
    public static final String COUNT_WATCHDOG_ACQUIRE_SOCKET_FAILURE = "CountWatchdogAcquireSocketFailure";
    public static final String COUNT_WATCHDOG_ACQUIRE_SOCKET_INTERFACE = "CountWatchdogAcquireSocketInterface";
    public static final String COUNT_WATCHDOG_ACQUIRE_SOCKET_REASON = "CountWatchdogAcquireSocketReason";
    public static final String COUNT_WATCHDOG_ACQUIRE_SOCKET_SUCCESSFUL = "CountWatchdogAcquireSocketSuccessful";
    public static final String COUNT_WATCHDOG_ACQUIRE_UNHANDLED_EXCEPTION = "CountWatchdogAcquireUnhandledException";
    public static final String IDENTITY_ENDPOINT_RESOLUTIONS_FAILURE = "IdentityEndpointResolutionsFailure";
    public static final String PROGRAM_ID = "TComm";
    public static final String TIME_ACQUIRE_CONNECTED_CONNECTION = "TimeAcquireConnectedConnection";
    public static final String TIME_ACQUIRE_CONNECTION = "TimeAcquireConnection";
    public static final String TIME_BYTE_BUFFER_CHAIN_MESSAGE_QUEUE = "TimeByteBufferChainWorkerQueue";
    public static final String TIME_COMPUTE_CHECKSUM = "TimeComputeChecksum";
    public static final String TIME_CONNECTIVITY_DURATION = "TimeConnectivityDuration";
    public static final String TIME_CONVERT_MESSAGE_TO_REQUEST = "TimeConvertMessageToRequest";
    public static final String TIME_CONVERT_RESPONSE_TO_MESSAGE = "TimeConvertResponseToMessage";
    public static final String TIME_DECRYPT_DATA = "TimeDecryptData";
    public static final String TIME_DO_SSL_HANDSHAKE = "TimeDoSslHandshake";
    public static final String TIME_ENCODE_MESSAGE = "TimeEncodeMessage";
    public static final String TIME_ENCODE_RELIABLE_MESSAGE = "TimeEncodeReliableMessage";
    public static final String TIME_ENCRYPT_DATA = "TimeEncryptData";
    public static final String TIME_ESTABLISH_NAME_LOOKUP_BEFORE_UNDERLYING_SOCKET_CHANNEL = "TimeEstablishNameLookup";
    public static final String TIME_ESTABLISH_NEW_CONNECTION = "TimeEstablishNewConnection";
    public static final String TIME_ESTABLISH_SOCKET_CHANNEL = "TimeEstablishSocketChannel";
    public static final String TIME_ESTABLISH_SSL_SOCKET_CHANNEL = "TimeEstablishSslSocketChannel";
    public static final String TIME_ESTABLISH_UNDERLYING_SOCKET_CHANNEL_BEFORE_SSL = "TimeEstablishUnderlyingSocketChannelBeforeSsl";
    public static final String TIME_HEARTBEAT_INTERVAL = "TimeHeartbeatInterval";
    public static final String TIME_KEEP_ALIVE_CONNECTION_DURATION_WHEN_CONNECTIVITY_CHANGED = "TimeTcpKeepAliveCheckerConnectionDurationWhenConnectivityChanged";
    public static final String TIME_KEEP_ALIVE_CONNECTION_DURATION_WHEN_KEEP_ALIVE_FAILED = "TimeTcpKeepAliveCheckerConnectionDurationWhenKeepAliveFailed";
    public static final String TIME_KEEP_ALIVE_CONNECTION_DURATION_WHEN_KEEP_ALIVE_SUCCEEDED = "TimeTcpKeepAliveCheckerConnectionDurationWhenKeepAliveSucceeded";
    public static final String TIME_LEARNT_HEARTBEAT_INTERVAL = "TimeLearntHeartbeatInterval";
    public static final String TIME_NETWORK_CONNECTED_BUT_NO_ALWAYS_ON_SOCKET = "TimeNetworkConnectedButNoAlwaysOnSocket";
    public static final String TIME_NO_CONNECTIVITY_DURATION = "TimeNoConnectivityDuration";
    public static final String TIME_RAW_HTTP_SOCKET_WORKER_QUEUE = "TimeRawHttpSocketWorkerQueue";
    public static final String TIME_RESPONSE_ON_RAW_HTTP_SOCKET = "TimeResponseOnRawHttpSocket";
    public static final String TIME_SEND_ACK = "TimeSendAck";
    public static final String TIME_SEND_MESSAGE = "TimeSendMessage";
    public static final String TIME_SEND_MESSAGE_SERVICE_SIDE = "TimeSendMessageServiceSide";
    public static final String TIME_SEND_NACK = "TimeSendNack";
    public static final String TIME_SEND_ON_BYTE_BUFFER_CHAIN = "TimeSendOnByteBufferChain";
    public static final String TIME_SEND_PACK = "TimeSendPack";
    public static final String TIME_SEND_RELIABLE_MESSAGE = "TimeSendReliableMessage";
    public static final String TIME_SEND_RELIABLE_MESSAGE_SERVICE_SIDE = "TimeSendReliableMessageServiceSide";
    public static final String TIME_SEND_RELIABLE_MESSAGE_TO_RECEIVE_ACK = "TimeSendReliableMessageToReceiveAck";
    public static final String TIME_SEND_RELIABLE_MESSAGE_TO_RECEIVE_NACK = "TimeSendReliableMessageToReceiveNack";
    public static final String TIME_SEND_RELIABLE_MESSAGE_TO_RECEIVE_PACK = "TimeSendReliableMessageToReceivePack";
    public static final String TIME_SEND_REQUEST = "TimeSendRequest";
    public static final String TIME_SEND_REQUEST_SERVICE_SIDE = "TimeSendRequestServiceSide";
    public static final String TIME_SIGN_REQUEST = "TimeSignRequest";
    public static final String TIME_SOCKET_STALENESS_BUFFER_ELAPSED = "TimeSocketStalenessBufferElapsed";
    public static final String TIME_SRR_SERVICE_SIDE = "TimeSrrServiceSide";
    public static final String TIME_TUNING = "TimeTuning";
    public static final String TIME_TUNING_SSL = "TimeTuningSsl";
    public static final String TIME_UPGRADE_TO_WEBSOCKET = "TimeUpgradeToWebsocket";
    public static final String TIME_UPGRADE_TO_WEBSOCKET_SSL = "TimeUpgradeToWebsocketSsl";
    public static final String TIME_WATCHDOG_ACQUIRE_SOCKET_INSECURE = "TimeWatchdogAcquireSocketInsecure";
    public static final String TIME_WATCHDOG_ACQUIRE_SOCKET_SECURE = "TimeWatchdogAcquireSocketSecure";
    public static final String TIME_WATCHDOG_CONNECTION_DURATION = "TimeWatchdogConnectionDuration";

    public TCommMetrics()
    {
    }

    public static String suffixEthernet(String s)
    {
        return (new StringBuilder()).append(s).append("Lan").toString();
    }

    public static String suffixWan(String s)
    {
        return (new StringBuilder()).append(s).append("Wan").toString();
    }

    public static String suffixWanAndSim(String s, String s1)
    {
        return (new StringBuilder()).append(s).append("Wan").append("Sim").append(s1).toString();
    }

    public static String suffixWanAndTower(String s, String s1)
    {
        return (new StringBuilder()).append(s).append("Wan").append("Tower").append(s1).toString();
    }

    public static String suffixWifi(String s)
    {
        return (new StringBuilder()).append(s).append("Wifi").toString();
    }
}
