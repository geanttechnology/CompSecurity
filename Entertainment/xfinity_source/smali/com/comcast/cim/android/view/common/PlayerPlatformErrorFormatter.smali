.class public Lcom/comcast/cim/android/view/common/PlayerPlatformErrorFormatter;
.super Ljava/lang/Object;
.source "PlayerPlatformErrorFormatter.java"

# interfaces
.implements Lcom/comcast/cim/android/view/common/errorformatter/ErrorFormatter;


# instance fields
.field private final resources:Landroid/content/res/Resources;


# direct methods
.method public constructor <init>(Landroid/content/res/Resources;)V
    .locals 0
    .param p1, "resources"    # Landroid/content/res/Resources;

    .prologue
    .line 13
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 14
    iput-object p1, p0, Lcom/comcast/cim/android/view/common/PlayerPlatformErrorFormatter;->resources:Landroid/content/res/Resources;

    .line 15
    return-void
.end method

.method private getDescriptionResourceForError(Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformErrorException;)I
    .locals 1
    .param p1, "platformError"    # Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformErrorException;

    .prologue
    .line 41
    invoke-virtual {p1}, Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformErrorException;->getMajorCode()I

    move-result v0

    sparse-switch v0, :sswitch_data_0

    .line 137
    sget v0, Lcom/xfinity/playerlib/R$string;->video_playback_error_msg_default:I

    :goto_0
    return v0

    .line 44
    :sswitch_0
    sget v0, Lcom/xfinity/playerlib/R$string;->player_platform_error_msg_connection_problem:I

    goto :goto_0

    .line 51
    :sswitch_1
    sget v0, Lcom/xfinity/playerlib/R$string;->player_platform_error_msg_upgrade_required:I

    goto :goto_0

    .line 54
    :sswitch_2
    sget v0, Lcom/xfinity/playerlib/R$string;->player_platform_error_msg_video_corrupted:I

    goto :goto_0

    .line 57
    :sswitch_3
    sget v0, Lcom/xfinity/playerlib/R$string;->player_platform_error_msg_subscription_required:I

    goto :goto_0

    .line 61
    :sswitch_4
    sget v0, Lcom/xfinity/playerlib/R$string;->player_platform_error_msg_video_expired:I

    goto :goto_0

    .line 64
    :sswitch_5
    sget v0, Lcom/xfinity/playerlib/R$string;->player_platform_error_msg_device_registration_problem:I

    goto :goto_0

    .line 73
    :sswitch_6
    sget v0, Lcom/xfinity/playerlib/R$string;->player_platform_error_msg_app_corrupted:I

    goto :goto_0

    .line 76
    :sswitch_7
    sget v0, Lcom/xfinity/playerlib/R$string;->player_platform_error_msg_clock_tampering:I

    goto :goto_0

    .line 81
    :sswitch_8
    sget v0, Lcom/xfinity/playerlib/R$string;->player_platform_error_msg_unable_to_reach_auth_server:I

    goto :goto_0

    .line 84
    :sswitch_9
    invoke-virtual {p1}, Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformErrorException;->getMinorCode()I

    move-result v0

    invoke-direct {p0, v0}, Lcom/comcast/cim/android/view/common/PlayerPlatformErrorFormatter;->getMessageResourceForCustomError(I)I

    move-result v0

    goto :goto_0

    .line 87
    :sswitch_a
    sget v0, Lcom/xfinity/playerlib/R$string;->player_platform_error_msg_playback_disallowed_for_os:I

    goto :goto_0

    .line 90
    :sswitch_b
    sget v0, Lcom/xfinity/playerlib/R$string;->player_platform_error_msg_playback_disallowed_for_device:I

    goto :goto_0

    .line 93
    :sswitch_c
    sget v0, Lcom/xfinity/playerlib/R$string;->player_platform_error_msg_unable_to_play:I

    goto :goto_0

    .line 96
    :sswitch_d
    sget v0, Lcom/xfinity/playerlib/R$string;->player_platform_error_msg_restore_to_factory_settings:I

    goto :goto_0

    .line 99
    :sswitch_e
    sget v0, Lcom/xfinity/playerlib/R$string;->player_platform_error_msg_external_device_not_supported:I

    goto :goto_0

    .line 118
    :sswitch_f
    sget v0, Lcom/xfinity/playerlib/R$string;->video_playback_generic_error:I

    goto :goto_0

    .line 121
    :sswitch_10
    sget v0, Lcom/xfinity/playerlib/R$string;->player_platform_error_msg_playlist_problem:I

    goto :goto_0

    .line 124
    :sswitch_11
    sget v0, Lcom/xfinity/playerlib/R$string;->player_platform_error_msg_playlist_fetch_failed:I

    goto :goto_0

    .line 127
    :sswitch_12
    invoke-virtual {p1}, Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformErrorException;->isLocalPlayback()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 128
    invoke-virtual {p1}, Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformErrorException;->getMinorCode()I

    move-result v0

    invoke-direct {p0, v0}, Lcom/comcast/cim/android/view/common/PlayerPlatformErrorFormatter;->getMessageResourceForLocalAdobeNativeError(I)I

    move-result v0

    goto :goto_0

    .line 130
    :cond_0
    invoke-virtual {p1}, Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformErrorException;->getMinorCode()I

    move-result v0

    invoke-direct {p0, v0}, Lcom/comcast/cim/android/view/common/PlayerPlatformErrorFormatter;->getMessageResourceForAdobeNativeError(I)I

    move-result v0

    goto :goto_0

    .line 133
    :sswitch_13
    sget v0, Lcom/xfinity/playerlib/R$string;->player_platform_error_msg_espn_no_live_events:I

    goto :goto_0

    .line 135
    :sswitch_14
    sget v0, Lcom/xfinity/playerlib/R$string;->player_platform_error_msg_espn_playback_blacked_out:I

    goto :goto_0

    .line 41
    :sswitch_data_0
    .sparse-switch
        0x8 -> :sswitch_13
        0xce4 -> :sswitch_f
        0xce6 -> :sswitch_f
        0xce7 -> :sswitch_4
        0xce8 -> :sswitch_3
        0xce9 -> :sswitch_0
        0xcea -> :sswitch_1
        0xcec -> :sswitch_f
        0xced -> :sswitch_2
        0xcee -> :sswitch_f
        0xcef -> :sswitch_1
        0xcf0 -> :sswitch_f
        0xcf1 -> :sswitch_6
        0xcf9 -> :sswitch_5
        0xcfa -> :sswitch_6
        0xcfb -> :sswitch_6
        0xcfc -> :sswitch_6
        0xcfd -> :sswitch_6
        0xcfe -> :sswitch_6
        0xcff -> :sswitch_7
        0xd00 -> :sswitch_8
        0xd01 -> :sswitch_9
        0xd03 -> :sswitch_c
        0xd04 -> :sswitch_8
        0xd05 -> :sswitch_4
        0xd06 -> :sswitch_b
        0xd07 -> :sswitch_1
        0xd08 -> :sswitch_a
        0xd09 -> :sswitch_1
        0xd0a -> :sswitch_e
        0xd0f -> :sswitch_6
        0xd13 -> :sswitch_d
        0xd14 -> :sswitch_0
        0xd15 -> :sswitch_1
        0xd16 -> :sswitch_11
        0xd17 -> :sswitch_f
        0xd18 -> :sswitch_f
        0xd19 -> :sswitch_f
        0xd1a -> :sswitch_f
        0xd1b -> :sswitch_f
        0xd1c -> :sswitch_f
        0xd1d -> :sswitch_f
        0xd20 -> :sswitch_f
        0xd21 -> :sswitch_f
        0xd22 -> :sswitch_8
        0xd23 -> :sswitch_10
        0x1bbd -> :sswitch_14
        0x19e10 -> :sswitch_12
    .end sparse-switch
.end method

.method private getMessageResourceForAdobeNativeError(I)I
    .locals 1
    .param p1, "minorCode"    # I

    .prologue
    .line 161
    sparse-switch p1, :sswitch_data_0

    .line 193
    sget v0, Lcom/xfinity/playerlib/R$string;->video_playback_error_msg_default:I

    :goto_0
    return v0

    .line 166
    :sswitch_0
    sget v0, Lcom/xfinity/playerlib/R$string;->player_platform_error_msg_connection_problem:I

    goto :goto_0

    .line 172
    :sswitch_1
    sget v0, Lcom/xfinity/playerlib/R$string;->player_platform_error_msg_generic_device_not_supported:I

    goto :goto_0

    .line 177
    :sswitch_2
    sget v0, Lcom/xfinity/playerlib/R$string;->player_platform_error_msg_io_error:I

    goto :goto_0

    .line 180
    :sswitch_3
    sget v0, Lcom/xfinity/playerlib/R$string;->player_platform_error_msg_file_not_found:I

    goto :goto_0

    .line 187
    :sswitch_4
    sget v0, Lcom/xfinity/playerlib/R$string;->player_platform_error_msg_video_corrupted:I

    goto :goto_0

    .line 190
    :sswitch_5
    sget v0, Lcom/xfinity/playerlib/R$string;->player_platform_error_msg_playlist_problem:I

    goto :goto_0

    .line 161
    :sswitch_data_0
    .sparse-switch
        0x2 -> :sswitch_4
        0x5 -> :sswitch_3
        0xc -> :sswitch_4
        0x1a -> :sswitch_4
        0x1d -> :sswitch_1
        0x1f -> :sswitch_1
        0x20 -> :sswitch_0
        0x21 -> :sswitch_0
        0x23 -> :sswitch_1
        0x29 -> :sswitch_1
        0x2b -> :sswitch_0
        0x2c -> :sswitch_0
        0x2e -> :sswitch_4
        0x2f -> :sswitch_5
        0x37 -> :sswitch_4
        0x4e -> :sswitch_2
        0x4f -> :sswitch_2
        0x50 -> :sswitch_2
    .end sparse-switch
.end method

.method private getMessageResourceForCustomError(I)I
    .locals 1
    .param p1, "minorCode"    # I

    .prologue
    .line 143
    sparse-switch p1, :sswitch_data_0

    .line 156
    sget v0, Lcom/xfinity/playerlib/R$string;->video_playback_error_msg_default:I

    :goto_0
    return v0

    .line 145
    :sswitch_0
    sget v0, Lcom/xfinity/playerlib/R$string;->player_platform_error_msg_license_server_communication_problem:I

    goto :goto_0

    .line 147
    :sswitch_1
    sget v0, Lcom/xfinity/playerlib/R$string;->video_max_registered_devices:I

    goto :goto_0

    .line 149
    :sswitch_2
    sget v0, Lcom/xfinity/playerlib/R$string;->video_max_per_household_streams:I

    goto :goto_0

    .line 151
    :sswitch_3
    sget v0, Lcom/xfinity/playerlib/R$string;->video_max_per_household_streams_another_user:I

    goto :goto_0

    .line 153
    :sswitch_4
    sget v0, Lcom/xfinity/playerlib/R$string;->player_platform_error_msg_unable_to_play:I

    goto :goto_0

    .line 143
    nop

    :sswitch_data_0
    .sparse-switch
        0x191 -> :sswitch_4
        0x194 -> :sswitch_0
        0x19c -> :sswitch_1
        0x1a4 -> :sswitch_2
        0x1ac -> :sswitch_3
    .end sparse-switch
.end method

.method private getMessageResourceForLocalAdobeNativeError(I)I
    .locals 1
    .param p1, "minorCode"    # I

    .prologue
    .line 198
    packed-switch p1, :pswitch_data_0

    .line 202
    invoke-direct {p0, p1}, Lcom/comcast/cim/android/view/common/PlayerPlatformErrorFormatter;->getMessageResourceForAdobeNativeError(I)I

    move-result v0

    :goto_0
    return v0

    .line 200
    :pswitch_0
    sget v0, Lcom/xfinity/playerlib/R$string;->player_platform_error_msg_variant_deleted:I

    goto :goto_0

    .line 198
    nop

    :pswitch_data_0
    .packed-switch 0x5
        :pswitch_0
    .end packed-switch
.end method

.method private isOriginalOperationRetryable(Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformErrorException;)Z
    .locals 2
    .param p1, "platformError"    # Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformErrorException;

    .prologue
    .line 30
    invoke-direct {p0, p1}, Lcom/comcast/cim/android/view/common/PlayerPlatformErrorFormatter;->getDescriptionResourceForError(Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformErrorException;)I

    move-result v0

    .line 31
    .local v0, "messageResource":I
    sget v1, Lcom/xfinity/playerlib/R$string;->video_playback_error_msg_default:I

    if-eq v0, v1, :cond_0

    sget v1, Lcom/xfinity/playerlib/R$string;->player_platform_error_msg_device_registration_problem:I

    if-eq v0, v1, :cond_0

    sget v1, Lcom/xfinity/playerlib/R$string;->player_platform_error_msg_external_device_not_supported:I

    if-eq v0, v1, :cond_0

    sget v1, Lcom/xfinity/playerlib/R$string;->player_platform_error_msg_connection_problem:I

    if-eq v0, v1, :cond_0

    sget v1, Lcom/xfinity/playerlib/R$string;->player_platform_error_msg_playlist_fetch_failed:I

    if-eq v0, v1, :cond_0

    sget v1, Lcom/xfinity/playerlib/R$string;->player_platform_error_msg_unable_to_reach_auth_server:I

    if-eq v0, v1, :cond_0

    sget v1, Lcom/xfinity/playerlib/R$string;->player_platform_error_msg_file_not_found:I

    if-ne v0, v1, :cond_1

    :cond_0
    const/4 v1, 0x1

    :goto_0
    return v1

    :cond_1
    const/4 v1, 0x0

    goto :goto_0
.end method


# virtual methods
.method public formatError(Ljava/lang/Throwable;)Lcom/comcast/cim/android/view/common/errorformatter/FormattedError;
    .locals 10
    .param p1, "error"    # Ljava/lang/Throwable;

    .prologue
    const/4 v4, 0x0

    .line 19
    instance-of v5, p1, Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformErrorException;

    if-nez v5, :cond_0

    .line 26
    :goto_0
    return-object v4

    :cond_0
    move-object v1, p1

    .line 22
    check-cast v1, Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformErrorException;

    .line 23
    .local v1, "platformError":Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformErrorException;
    const-string v5, "%s :: %s"

    const/4 v6, 0x2

    new-array v6, v6, [Ljava/lang/Object;

    const/4 v7, 0x0

    iget-object v8, p0, Lcom/comcast/cim/android/view/common/PlayerPlatformErrorFormatter;->resources:Landroid/content/res/Resources;

    sget v9, Lcom/xfinity/playerlib/R$string;->dlg_title_error:I

    invoke-virtual {v8, v9}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v8

    aput-object v8, v6, v7

    const/4 v7, 0x1

    invoke-virtual {v1}, Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformErrorException;->getRawCode()Ljava/lang/String;

    move-result-object v8

    aput-object v8, v6, v7

    invoke-static {v5, v6}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    .line 24
    .local v3, "title":Ljava/lang/String;
    iget-object v5, p0, Lcom/comcast/cim/android/view/common/PlayerPlatformErrorFormatter;->resources:Landroid/content/res/Resources;

    invoke-direct {p0, v1}, Lcom/comcast/cim/android/view/common/PlayerPlatformErrorFormatter;->getDescriptionResourceForError(Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformErrorException;)I

    move-result v6

    invoke-virtual {v5, v6}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    .line 25
    .local v0, "description":Ljava/lang/String;
    invoke-direct {p0, v1}, Lcom/comcast/cim/android/view/common/PlayerPlatformErrorFormatter;->isOriginalOperationRetryable(Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformErrorException;)Z

    move-result v2

    .line 26
    .local v2, "retryable":Z
    new-instance v5, Lcom/comcast/cim/android/view/common/errorformatter/FormattedError;

    invoke-direct {v5, v3, v0, v4, v2}, Lcom/comcast/cim/android/view/common/errorformatter/FormattedError;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V

    move-object v4, v5

    goto :goto_0
.end method
