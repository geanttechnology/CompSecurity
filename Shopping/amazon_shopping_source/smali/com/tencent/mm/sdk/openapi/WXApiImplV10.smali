.class final Lcom/tencent/mm/sdk/openapi/WXApiImplV10;
.super Ljava/lang/Object;
.source "WXApiImplV10.java"

# interfaces
.implements Lcom/tencent/mm/sdk/openapi/IWXAPI;


# static fields
.field private static wxappPayEntryClassname:Ljava/lang/String;


# instance fields
.field private appId:Ljava/lang/String;

.field private checkSignature:Z

.field private context:Landroid/content/Context;

.field private detached:Z


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 282
    const/4 v0, 0x0

    sput-object v0, Lcom/tencent/mm/sdk/openapi/WXApiImplV10;->wxappPayEntryClassname:Ljava/lang/String;

    return-void
.end method

.method constructor <init>(Landroid/content/Context;Ljava/lang/String;Z)V
    .locals 3
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "appId"    # Ljava/lang/String;
    .param p3, "checkSignature"    # Z

    .prologue
    const/4 v0, 0x0

    .line 44
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 41
    iput-boolean v0, p0, Lcom/tencent/mm/sdk/openapi/WXApiImplV10;->checkSignature:Z

    .line 42
    iput-boolean v0, p0, Lcom/tencent/mm/sdk/openapi/WXApiImplV10;->detached:Z

    .line 45
    const-string/jumbo v0, "MicroMsg.SDK.WXApiImplV10"

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v2, "<init>, appId = "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string/jumbo v2, ", checkSignature = "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p3}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/tencent/mm/sdk/platformtools/Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 46
    iput-object p1, p0, Lcom/tencent/mm/sdk/openapi/WXApiImplV10;->context:Landroid/content/Context;

    .line 47
    iput-object p2, p0, Lcom/tencent/mm/sdk/openapi/WXApiImplV10;->appId:Ljava/lang/String;

    .line 48
    iput-boolean p3, p0, Lcom/tencent/mm/sdk/openapi/WXApiImplV10;->checkSignature:Z

    .line 49
    return-void
.end method

.method private checkSumConsistent([B[B)Z
    .locals 4
    .param p1, "src"    # [B
    .param p2, "gen"    # [B

    .prologue
    const/4 v1, 0x0

    .line 358
    if-eqz p1, :cond_0

    array-length v2, p1

    if-eqz v2, :cond_0

    if-eqz p2, :cond_0

    array-length v2, p2

    if-nez v2, :cond_2

    .line 360
    :cond_0
    const-string/jumbo v2, "MicroMsg.SDK.WXApiImplV10"

    const-string/jumbo v3, "checkSumConsistent fail, invalid arguments"

    invoke-static {v2, v3}, Lcom/tencent/mm/sdk/platformtools/Log;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 375
    :cond_1
    :goto_0
    return v1

    .line 364
    :cond_2
    array-length v2, p1

    array-length v3, p2

    if-eq v2, v3, :cond_3

    .line 365
    const-string/jumbo v2, "MicroMsg.SDK.WXApiImplV10"

    const-string/jumbo v3, "checkSumConsistent fail, length is different"

    invoke-static {v2, v3}, Lcom/tencent/mm/sdk/platformtools/Log;->e(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 369
    :cond_3
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_1
    array-length v2, p1

    if-ge v0, v2, :cond_4

    .line 370
    aget-byte v2, p1, v0

    aget-byte v3, p2, v0

    if-ne v2, v3, :cond_1

    .line 369
    add-int/lit8 v0, v0, 0x1

    goto :goto_1

    .line 375
    :cond_4
    const/4 v1, 0x1

    goto :goto_0
.end method

.method private sendJumpToBizProfileReq(Landroid/content/Context;Landroid/os/Bundle;)Z
    .locals 8
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "data"    # Landroid/os/Bundle;

    .prologue
    const/4 v7, 0x1

    const/4 v2, 0x0

    .line 305
    invoke-virtual {p1}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v0

    .line 306
    .local v0, "resolver":Landroid/content/ContentResolver;
    const-string/jumbo v3, "content://com.tencent.mm.sdk.comm.provider/jumpToBizProfile"

    invoke-static {v3}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v1

    .line 307
    .local v1, "uri":Landroid/net/Uri;
    const/4 v3, 0x5

    new-array v4, v3, [Ljava/lang/String;

    const/4 v3, 0x0

    iget-object v5, p0, Lcom/tencent/mm/sdk/openapi/WXApiImplV10;->appId:Ljava/lang/String;

    aput-object v5, v4, v3

    const-string/jumbo v3, "_wxapi_jump_to_biz_profile_req_to_user_name"

    invoke-virtual {p2, v3}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    aput-object v3, v4, v7

    const/4 v3, 0x2

    const-string/jumbo v5, "_wxapi_jump_to_biz_profile_req_ext_msg"

    invoke-virtual {p2, v5}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    aput-object v5, v4, v3

    const/4 v3, 0x3

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v6, "_wxapi_jump_to_biz_profile_req_scene"

    invoke-virtual {p2, v6}, Landroid/os/Bundle;->getInt(Ljava/lang/String;)I

    move-result v6

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string/jumbo v6, ""

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v4, v3

    const/4 v3, 0x4

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v6, "_wxapi_jump_to_biz_profile_req_profile_type"

    invoke-virtual {p2, v6}, Landroid/os/Bundle;->getInt(Ljava/lang/String;)I

    move-result v6

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string/jumbo v6, ""

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v4, v3

    .local v4, "selectionArgs":[Ljava/lang/String;
    move-object v3, v2

    move-object v5, v2

    .line 309
    invoke-virtual/range {v0 .. v5}, Landroid/content/ContentResolver;->query(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    .line 310
    return v7
.end method

.method private sendJumpToBizWebviewReq(Landroid/content/Context;Landroid/os/Bundle;)Z
    .locals 8
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "data"    # Landroid/os/Bundle;

    .prologue
    const/4 v7, 0x1

    const/4 v2, 0x0

    .line 314
    invoke-virtual {p1}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v0

    .line 315
    .local v0, "resolver":Landroid/content/ContentResolver;
    const-string/jumbo v3, "content://com.tencent.mm.sdk.comm.provider/jumpToBizProfile"

    invoke-static {v3}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v1

    .line 316
    .local v1, "uri":Landroid/net/Uri;
    const/4 v3, 0x4

    new-array v4, v3, [Ljava/lang/String;

    const/4 v3, 0x0

    iget-object v5, p0, Lcom/tencent/mm/sdk/openapi/WXApiImplV10;->appId:Ljava/lang/String;

    aput-object v5, v4, v3

    const-string/jumbo v3, "_wxapi_jump_to_biz_webview_req_to_user_name"

    invoke-virtual {p2, v3}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    aput-object v3, v4, v7

    const/4 v3, 0x2

    const-string/jumbo v5, "_wxapi_jump_to_biz_webview_req_ext_msg"

    invoke-virtual {p2, v5}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    aput-object v5, v4, v3

    const/4 v3, 0x3

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v6, "_wxapi_jump_to_biz_webview_req_scene"

    invoke-virtual {p2, v6}, Landroid/os/Bundle;->getInt(Ljava/lang/String;)I

    move-result v6

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string/jumbo v6, ""

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v4, v3

    .local v4, "selectionArgs":[Ljava/lang/String;
    move-object v3, v2

    move-object v5, v2

    .line 318
    invoke-virtual/range {v0 .. v5}, Landroid/content/ContentResolver;->query(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    .line 319
    return v7
.end method

.method private sendPayReq(Landroid/content/Context;Landroid/os/Bundle;)Z
    .locals 5
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "data"    # Landroid/os/Bundle;

    .prologue
    .line 285
    sget-object v2, Lcom/tencent/mm/sdk/openapi/WXApiImplV10;->wxappPayEntryClassname:Ljava/lang/String;

    if-nez v2, :cond_0

    .line 286
    new-instance v1, Lcom/tencent/mm/sdk/openapi/MMSharedPreferences;

    invoke-direct {v1, p1}, Lcom/tencent/mm/sdk/openapi/MMSharedPreferences;-><init>(Landroid/content/Context;)V

    .line 287
    .local v1, "sp":Lcom/tencent/mm/sdk/openapi/MMSharedPreferences;
    const-string/jumbo v2, "_wxapp_pay_entry_classname_"

    const/4 v3, 0x0

    invoke-virtual {v1, v2, v3}, Lcom/tencent/mm/sdk/openapi/MMSharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    sput-object v2, Lcom/tencent/mm/sdk/openapi/WXApiImplV10;->wxappPayEntryClassname:Ljava/lang/String;

    .line 288
    const-string/jumbo v2, "MicroMsg.SDK.WXApiImplV10"

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v4, "pay, set wxappPayEntryClassname = "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    sget-object v4, Lcom/tencent/mm/sdk/openapi/WXApiImplV10;->wxappPayEntryClassname:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Lcom/tencent/mm/sdk/platformtools/Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 290
    sget-object v2, Lcom/tencent/mm/sdk/openapi/WXApiImplV10;->wxappPayEntryClassname:Ljava/lang/String;

    if-nez v2, :cond_0

    .line 291
    const-string/jumbo v2, "MicroMsg.SDK.WXApiImplV10"

    const-string/jumbo v3, "pay fail, wxappPayEntryClassname is null"

    invoke-static {v2, v3}, Lcom/tencent/mm/sdk/platformtools/Log;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 292
    const/4 v2, 0x0

    .line 301
    .end local v1    # "sp":Lcom/tencent/mm/sdk/openapi/MMSharedPreferences;
    :goto_0
    return v2

    .line 296
    :cond_0
    new-instance v0, Lcom/tencent/mm/sdk/channel/MMessageActV2$Args;

    invoke-direct {v0}, Lcom/tencent/mm/sdk/channel/MMessageActV2$Args;-><init>()V

    .line 297
    .local v0, "args":Lcom/tencent/mm/sdk/channel/MMessageActV2$Args;
    iput-object p2, v0, Lcom/tencent/mm/sdk/channel/MMessageActV2$Args;->bundle:Landroid/os/Bundle;

    .line 298
    const-string/jumbo v2, "com.tencent.mm"

    iput-object v2, v0, Lcom/tencent/mm/sdk/channel/MMessageActV2$Args;->targetPkgName:Ljava/lang/String;

    .line 299
    sget-object v2, Lcom/tencent/mm/sdk/openapi/WXApiImplV10;->wxappPayEntryClassname:Ljava/lang/String;

    iput-object v2, v0, Lcom/tencent/mm/sdk/channel/MMessageActV2$Args;->targetClassName:Ljava/lang/String;

    .line 301
    invoke-static {p1, v0}, Lcom/tencent/mm/sdk/channel/MMessageActV2;->send(Landroid/content/Context;Lcom/tencent/mm/sdk/channel/MMessageActV2$Args;)Z

    move-result v2

    goto :goto_0
.end method


# virtual methods
.method public getWXAppSupportAPI()I
    .locals 4

    .prologue
    const/4 v1, 0x0

    .line 207
    iget-boolean v2, p0, Lcom/tencent/mm/sdk/openapi/WXApiImplV10;->detached:Z

    if-eqz v2, :cond_0

    .line 208
    new-instance v1, Ljava/lang/IllegalStateException;

    const-string/jumbo v2, "getWXAppSupportAPI fail, WXMsgImpl has been detached"

    invoke-direct {v1, v2}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 211
    :cond_0
    invoke-virtual {p0}, Lcom/tencent/mm/sdk/openapi/WXApiImplV10;->isWXAppInstalled()Z

    move-result v2

    if-nez v2, :cond_1

    .line 212
    const-string/jumbo v2, "MicroMsg.SDK.WXApiImplV10"

    const-string/jumbo v3, "open wx app failed, not installed or signature check failed"

    invoke-static {v2, v3}, Lcom/tencent/mm/sdk/platformtools/Log;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 217
    :goto_0
    return v1

    .line 216
    :cond_1
    new-instance v0, Lcom/tencent/mm/sdk/openapi/MMSharedPreferences;

    iget-object v2, p0, Lcom/tencent/mm/sdk/openapi/WXApiImplV10;->context:Landroid/content/Context;

    invoke-direct {v0, v2}, Lcom/tencent/mm/sdk/openapi/MMSharedPreferences;-><init>(Landroid/content/Context;)V

    .line 217
    .local v0, "sp":Lcom/tencent/mm/sdk/openapi/MMSharedPreferences;
    const-string/jumbo v2, "_build_info_sdk_int_"

    invoke-virtual {v0, v2, v1}, Lcom/tencent/mm/sdk/openapi/MMSharedPreferences;->getInt(Ljava/lang/String;I)I

    move-result v1

    goto :goto_0
.end method

.method public handleIntent(Landroid/content/Intent;Lcom/tencent/mm/sdk/openapi/IWXAPIEventHandler;)Z
    .locals 12
    .param p1, "data"    # Landroid/content/Intent;
    .param p2, "handler"    # Lcom/tencent/mm/sdk/openapi/IWXAPIEventHandler;

    .prologue
    const/4 v9, 0x1

    const/4 v8, 0x0

    .line 106
    const-string/jumbo v10, "com.tencent.mm.openapi.token"

    invoke-static {p1, v10}, Lcom/tencent/mm/sdk/openapi/WXApiImplComm;->isIntentFromWx(Landroid/content/Intent;Ljava/lang/String;)Z

    move-result v10

    if-nez v10, :cond_0

    .line 107
    const-string/jumbo v9, "MicroMsg.SDK.WXApiImplV10"

    const-string/jumbo v10, "handleIntent fail, intent not from weixin msg"

    invoke-static {v9, v10}, Lcom/tencent/mm/sdk/platformtools/Log;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 175
    :goto_0
    return v8

    .line 111
    :cond_0
    iget-boolean v10, p0, Lcom/tencent/mm/sdk/openapi/WXApiImplV10;->detached:Z

    if-eqz v10, :cond_1

    .line 112
    new-instance v8, Ljava/lang/IllegalStateException;

    const-string/jumbo v9, "handleIntent fail, WXMsgImpl has been detached"

    invoke-direct {v8, v9}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v8

    .line 115
    :cond_1
    const-string/jumbo v10, "_mmessage_content"

    invoke-virtual {p1, v10}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 116
    .local v1, "content":Ljava/lang/String;
    const-string/jumbo v10, "_mmessage_sdkVersion"

    invoke-virtual {p1, v10, v8}, Landroid/content/Intent;->getIntExtra(Ljava/lang/String;I)I

    move-result v6

    .line 117
    .local v6, "sdkVersion":I
    const-string/jumbo v10, "_mmessage_appPackage"

    invoke-virtual {p1, v10}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    .line 120
    .local v3, "packageName":Ljava/lang/String;
    if-eqz v3, :cond_2

    invoke-virtual {v3}, Ljava/lang/String;->length()I

    move-result v10

    if-nez v10, :cond_3

    .line 121
    :cond_2
    const-string/jumbo v9, "MicroMsg.SDK.WXApiImplV10"

    const-string/jumbo v10, "invalid argument"

    invoke-static {v9, v10}, Lcom/tencent/mm/sdk/platformtools/Log;->e(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 125
    :cond_3
    const-string/jumbo v10, "_mmessage_checksum"

    invoke-virtual {p1, v10}, Landroid/content/Intent;->getByteArrayExtra(Ljava/lang/String;)[B

    move-result-object v7

    .line 126
    .local v7, "srcCheckSum":[B
    invoke-static {v1, v6, v3}, Lcom/tencent/mm/sdk/channel/compatible/MMessageUtil;->genCheckSum(Ljava/lang/String;ILjava/lang/String;)[B

    move-result-object v2

    .line 128
    .local v2, "genCheckSum":[B
    invoke-direct {p0, v7, v2}, Lcom/tencent/mm/sdk/openapi/WXApiImplV10;->checkSumConsistent([B[B)Z

    move-result v10

    if-nez v10, :cond_4

    .line 129
    const-string/jumbo v9, "MicroMsg.SDK.WXApiImplV10"

    const-string/jumbo v10, "checksum fail"

    invoke-static {v9, v10}, Lcom/tencent/mm/sdk/platformtools/Log;->e(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 133
    :cond_4
    const-string/jumbo v10, "_wxapi_command_type"

    invoke-virtual {p1, v10, v8}, Landroid/content/Intent;->getIntExtra(Ljava/lang/String;I)I

    move-result v0

    .line 134
    .local v0, "cmd":I
    packed-switch v0, :pswitch_data_0

    .line 172
    const-string/jumbo v9, "MicroMsg.SDK.WXApiImplV10"

    new-instance v10, Ljava/lang/StringBuilder;

    invoke-direct {v10}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v11, "unknown cmd = "

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v10, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v10}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v10

    invoke-static {v9, v10}, Lcom/tencent/mm/sdk/platformtools/Log;->e(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 136
    :pswitch_0
    new-instance v5, Lcom/tencent/mm/sdk/modelmsg/SendAuth$Resp;

    invoke-virtual {p1}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v8

    invoke-direct {v5, v8}, Lcom/tencent/mm/sdk/modelmsg/SendAuth$Resp;-><init>(Landroid/os/Bundle;)V

    .line 137
    .local v5, "resp":Lcom/tencent/mm/sdk/modelmsg/SendAuth$Resp;
    invoke-interface {p2, v5}, Lcom/tencent/mm/sdk/openapi/IWXAPIEventHandler;->onResp(Lcom/tencent/mm/sdk/modelbase/BaseResp;)V

    move v8, v9

    .line 138
    goto/16 :goto_0

    .line 142
    .end local v5    # "resp":Lcom/tencent/mm/sdk/modelmsg/SendAuth$Resp;
    :pswitch_1
    new-instance v5, Lcom/tencent/mm/sdk/modelmsg/SendMessageToWX$Resp;

    invoke-virtual {p1}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v8

    invoke-direct {v5, v8}, Lcom/tencent/mm/sdk/modelmsg/SendMessageToWX$Resp;-><init>(Landroid/os/Bundle;)V

    .line 143
    .local v5, "resp":Lcom/tencent/mm/sdk/modelmsg/SendMessageToWX$Resp;
    invoke-interface {p2, v5}, Lcom/tencent/mm/sdk/openapi/IWXAPIEventHandler;->onResp(Lcom/tencent/mm/sdk/modelbase/BaseResp;)V

    move v8, v9

    .line 144
    goto/16 :goto_0

    .line 148
    .end local v5    # "resp":Lcom/tencent/mm/sdk/modelmsg/SendMessageToWX$Resp;
    :pswitch_2
    new-instance v4, Lcom/tencent/mm/sdk/modelmsg/GetMessageFromWX$Req;

    invoke-virtual {p1}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v8

    invoke-direct {v4, v8}, Lcom/tencent/mm/sdk/modelmsg/GetMessageFromWX$Req;-><init>(Landroid/os/Bundle;)V

    .line 149
    .local v4, "req":Lcom/tencent/mm/sdk/modelmsg/GetMessageFromWX$Req;
    invoke-interface {p2, v4}, Lcom/tencent/mm/sdk/openapi/IWXAPIEventHandler;->onReq(Lcom/tencent/mm/sdk/modelbase/BaseReq;)V

    move v8, v9

    .line 150
    goto/16 :goto_0

    .line 154
    .end local v4    # "req":Lcom/tencent/mm/sdk/modelmsg/GetMessageFromWX$Req;
    :pswitch_3
    new-instance v4, Lcom/tencent/mm/sdk/modelmsg/ShowMessageFromWX$Req;

    invoke-virtual {p1}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v8

    invoke-direct {v4, v8}, Lcom/tencent/mm/sdk/modelmsg/ShowMessageFromWX$Req;-><init>(Landroid/os/Bundle;)V

    .line 155
    .local v4, "req":Lcom/tencent/mm/sdk/modelmsg/ShowMessageFromWX$Req;
    invoke-interface {p2, v4}, Lcom/tencent/mm/sdk/openapi/IWXAPIEventHandler;->onReq(Lcom/tencent/mm/sdk/modelbase/BaseReq;)V

    move v8, v9

    .line 156
    goto/16 :goto_0

    .line 160
    .end local v4    # "req":Lcom/tencent/mm/sdk/modelmsg/ShowMessageFromWX$Req;
    :pswitch_4
    new-instance v5, Lcom/tencent/mm/sdk/modelpay/PayResp;

    invoke-virtual {p1}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v8

    invoke-direct {v5, v8}, Lcom/tencent/mm/sdk/modelpay/PayResp;-><init>(Landroid/os/Bundle;)V

    .line 161
    .local v5, "resp":Lcom/tencent/mm/sdk/modelpay/PayResp;
    invoke-interface {p2, v5}, Lcom/tencent/mm/sdk/openapi/IWXAPIEventHandler;->onResp(Lcom/tencent/mm/sdk/modelbase/BaseResp;)V

    move v8, v9

    .line 162
    goto/16 :goto_0

    .line 166
    .end local v5    # "resp":Lcom/tencent/mm/sdk/modelpay/PayResp;
    :pswitch_5
    new-instance v4, Lcom/tencent/mm/sdk/modelmsg/LaunchFromWX$Req;

    invoke-virtual {p1}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v8

    invoke-direct {v4, v8}, Lcom/tencent/mm/sdk/modelmsg/LaunchFromWX$Req;-><init>(Landroid/os/Bundle;)V

    .line 167
    .local v4, "req":Lcom/tencent/mm/sdk/modelmsg/LaunchFromWX$Req;
    invoke-interface {p2, v4}, Lcom/tencent/mm/sdk/openapi/IWXAPIEventHandler;->onReq(Lcom/tencent/mm/sdk/modelbase/BaseReq;)V

    move v8, v9

    .line 168
    goto/16 :goto_0

    .line 134
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
        :pswitch_2
        :pswitch_3
        :pswitch_4
        :pswitch_5
    .end packed-switch
.end method

.method public isWXAppInstalled()Z
    .locals 6

    .prologue
    const/4 v2, 0x0

    .line 180
    iget-boolean v3, p0, Lcom/tencent/mm/sdk/openapi/WXApiImplV10;->detached:Z

    if-eqz v3, :cond_0

    .line 181
    new-instance v2, Ljava/lang/IllegalStateException;

    const-string/jumbo v3, "isWXAppInstalled fail, WXMsgImpl has been detached"

    invoke-direct {v2, v3}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v2

    .line 185
    :cond_0
    :try_start_0
    iget-object v3, p0, Lcom/tencent/mm/sdk/openapi/WXApiImplV10;->context:Landroid/content/Context;

    invoke-virtual {v3}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v3

    const-string/jumbo v4, "com.tencent.mm"

    const/16 v5, 0x40

    invoke-virtual {v3, v4, v5}, Landroid/content/pm/PackageManager;->getPackageInfo(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;

    move-result-object v1

    .line 186
    .local v1, "packageInfo":Landroid/content/pm/PackageInfo;
    if-nez v1, :cond_1

    .line 192
    .end local v1    # "packageInfo":Landroid/content/pm/PackageInfo;
    :goto_0
    return v2

    .line 189
    .restart local v1    # "packageInfo":Landroid/content/pm/PackageInfo;
    :cond_1
    iget-object v3, p0, Lcom/tencent/mm/sdk/openapi/WXApiImplV10;->context:Landroid/content/Context;

    iget-object v4, v1, Landroid/content/pm/PackageInfo;->signatures:[Landroid/content/pm/Signature;

    iget-boolean v5, p0, Lcom/tencent/mm/sdk/openapi/WXApiImplV10;->checkSignature:Z

    invoke-static {v3, v4, v5}, Lcom/tencent/mm/sdk/openapi/WXApiImplComm;->validateAppSignature(Landroid/content/Context;[Landroid/content/pm/Signature;Z)Z
    :try_end_0
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    move-result v2

    goto :goto_0

    .line 191
    .end local v1    # "packageInfo":Landroid/content/pm/PackageInfo;
    :catch_0
    move-exception v0

    .line 192
    .local v0, "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    goto :goto_0
.end method

.method public registerApp(Ljava/lang/String;)Z
    .locals 4
    .param p1, "appId"    # Ljava/lang/String;

    .prologue
    .line 53
    iget-boolean v1, p0, Lcom/tencent/mm/sdk/openapi/WXApiImplV10;->detached:Z

    if-eqz v1, :cond_0

    .line 54
    new-instance v1, Ljava/lang/IllegalStateException;

    const-string/jumbo v2, "registerApp fail, WXMsgImpl has been detached"

    invoke-direct {v1, v2}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 57
    :cond_0
    iget-object v1, p0, Lcom/tencent/mm/sdk/openapi/WXApiImplV10;->context:Landroid/content/Context;

    const-string/jumbo v2, "com.tencent.mm"

    iget-boolean v3, p0, Lcom/tencent/mm/sdk/openapi/WXApiImplV10;->checkSignature:Z

    invoke-static {v1, v2, v3}, Lcom/tencent/mm/sdk/openapi/WXApiImplComm;->validateAppSignatureForPackage(Landroid/content/Context;Ljava/lang/String;Z)Z

    move-result v1

    if-nez v1, :cond_1

    .line 58
    const-string/jumbo v1, "MicroMsg.SDK.WXApiImplV10"

    const-string/jumbo v2, "register app failed for wechat app signature check failed"

    invoke-static {v1, v2}, Lcom/tencent/mm/sdk/platformtools/Log;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 59
    const/4 v1, 0x0

    .line 74
    :goto_0
    return v1

    .line 62
    :cond_1
    const-string/jumbo v1, "MicroMsg.SDK.WXApiImplV10"

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v3, "registerApp, appId = "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Lcom/tencent/mm/sdk/platformtools/Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 63
    if-eqz p1, :cond_2

    .line 64
    iput-object p1, p0, Lcom/tencent/mm/sdk/openapi/WXApiImplV10;->appId:Ljava/lang/String;

    .line 67
    :cond_2
    const-string/jumbo v1, "MicroMsg.SDK.WXApiImplV10"

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v3, "register app "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    iget-object v3, p0, Lcom/tencent/mm/sdk/openapi/WXApiImplV10;->context:Landroid/content/Context;

    invoke-virtual {v3}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Lcom/tencent/mm/sdk/platformtools/Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 69
    new-instance v0, Lcom/tencent/mm/sdk/channel/compatible/MMessage$Args;

    invoke-direct {v0}, Lcom/tencent/mm/sdk/channel/compatible/MMessage$Args;-><init>()V

    .line 70
    .local v0, "args":Lcom/tencent/mm/sdk/channel/compatible/MMessage$Args;
    const-string/jumbo v1, "com.tencent.mm"

    iput-object v1, v0, Lcom/tencent/mm/sdk/channel/compatible/MMessage$Args;->targetPkg:Ljava/lang/String;

    .line 71
    const-string/jumbo v1, "com.tencent.mm.plugin.openapi.Intent.ACTION_HANDLE_APP_REGISTER"

    iput-object v1, v0, Lcom/tencent/mm/sdk/channel/compatible/MMessage$Args;->action:Ljava/lang/String;

    .line 72
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v2, "weixin://registerapp?appid="

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/tencent/mm/sdk/openapi/WXApiImplV10;->appId:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lcom/tencent/mm/sdk/channel/compatible/MMessage$Args;->content:Ljava/lang/String;

    .line 74
    iget-object v1, p0, Lcom/tencent/mm/sdk/openapi/WXApiImplV10;->context:Landroid/content/Context;

    invoke-static {v1, v0}, Lcom/tencent/mm/sdk/channel/compatible/MMessage;->send(Landroid/content/Context;Lcom/tencent/mm/sdk/channel/compatible/MMessage$Args;)Z

    move-result v1

    goto :goto_0
.end method

.method public sendReq(Lcom/tencent/mm/sdk/modelbase/BaseReq;)Z
    .locals 6
    .param p1, "req"    # Lcom/tencent/mm/sdk/modelbase/BaseReq;

    .prologue
    const/4 v2, 0x0

    .line 242
    iget-boolean v3, p0, Lcom/tencent/mm/sdk/openapi/WXApiImplV10;->detached:Z

    if-eqz v3, :cond_0

    .line 243
    new-instance v2, Ljava/lang/IllegalStateException;

    const-string/jumbo v3, "sendReq fail, WXMsgImpl has been detached"

    invoke-direct {v2, v3}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v2

    .line 246
    :cond_0
    iget-object v3, p0, Lcom/tencent/mm/sdk/openapi/WXApiImplV10;->context:Landroid/content/Context;

    const-string/jumbo v4, "com.tencent.mm"

    iget-boolean v5, p0, Lcom/tencent/mm/sdk/openapi/WXApiImplV10;->checkSignature:Z

    invoke-static {v3, v4, v5}, Lcom/tencent/mm/sdk/openapi/WXApiImplComm;->validateAppSignatureForPackage(Landroid/content/Context;Ljava/lang/String;Z)Z

    move-result v3

    if-nez v3, :cond_1

    .line 247
    const-string/jumbo v3, "MicroMsg.SDK.WXApiImplV10"

    const-string/jumbo v4, "sendReq failed for wechat app signature check failed"

    invoke-static {v3, v4}, Lcom/tencent/mm/sdk/platformtools/Log;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 279
    :goto_0
    return v2

    .line 251
    :cond_1
    invoke-virtual {p1}, Lcom/tencent/mm/sdk/modelbase/BaseReq;->checkArgs()Z

    move-result v3

    if-nez v3, :cond_2

    .line 252
    const-string/jumbo v3, "MicroMsg.SDK.WXApiImplV10"

    const-string/jumbo v4, "sendReq checkArgs fail"

    invoke-static {v3, v4}, Lcom/tencent/mm/sdk/platformtools/Log;->e(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 256
    :cond_2
    const-string/jumbo v2, "MicroMsg.SDK.WXApiImplV10"

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v4, "sendReq, req type = "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {p1}, Lcom/tencent/mm/sdk/modelbase/BaseReq;->getType()I

    move-result v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Lcom/tencent/mm/sdk/platformtools/Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 258
    new-instance v1, Landroid/os/Bundle;

    invoke-direct {v1}, Landroid/os/Bundle;-><init>()V

    .line 259
    .local v1, "data":Landroid/os/Bundle;
    invoke-virtual {p1, v1}, Lcom/tencent/mm/sdk/modelbase/BaseReq;->toBundle(Landroid/os/Bundle;)V

    .line 261
    invoke-virtual {p1}, Lcom/tencent/mm/sdk/modelbase/BaseReq;->getType()I

    move-result v2

    const/4 v3, 0x5

    if-ne v2, v3, :cond_3

    .line 262
    iget-object v2, p0, Lcom/tencent/mm/sdk/openapi/WXApiImplV10;->context:Landroid/content/Context;

    invoke-direct {p0, v2, v1}, Lcom/tencent/mm/sdk/openapi/WXApiImplV10;->sendPayReq(Landroid/content/Context;Landroid/os/Bundle;)Z

    move-result v2

    goto :goto_0

    .line 265
    :cond_3
    invoke-virtual {p1}, Lcom/tencent/mm/sdk/modelbase/BaseReq;->getType()I

    move-result v2

    const/4 v3, 0x7

    if-ne v2, v3, :cond_4

    .line 266
    iget-object v2, p0, Lcom/tencent/mm/sdk/openapi/WXApiImplV10;->context:Landroid/content/Context;

    invoke-direct {p0, v2, v1}, Lcom/tencent/mm/sdk/openapi/WXApiImplV10;->sendJumpToBizProfileReq(Landroid/content/Context;Landroid/os/Bundle;)Z

    move-result v2

    goto :goto_0

    .line 269
    :cond_4
    invoke-virtual {p1}, Lcom/tencent/mm/sdk/modelbase/BaseReq;->getType()I

    move-result v2

    const/16 v3, 0x8

    if-ne v2, v3, :cond_5

    .line 270
    iget-object v2, p0, Lcom/tencent/mm/sdk/openapi/WXApiImplV10;->context:Landroid/content/Context;

    invoke-direct {p0, v2, v1}, Lcom/tencent/mm/sdk/openapi/WXApiImplV10;->sendJumpToBizWebviewReq(Landroid/content/Context;Landroid/os/Bundle;)Z

    move-result v2

    goto :goto_0

    .line 273
    :cond_5
    new-instance v0, Lcom/tencent/mm/sdk/channel/MMessageActV2$Args;

    invoke-direct {v0}, Lcom/tencent/mm/sdk/channel/MMessageActV2$Args;-><init>()V

    .line 274
    .local v0, "args":Lcom/tencent/mm/sdk/channel/MMessageActV2$Args;
    iput-object v1, v0, Lcom/tencent/mm/sdk/channel/MMessageActV2$Args;->bundle:Landroid/os/Bundle;

    .line 275
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v3, "weixin://sendreq?appid="

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    iget-object v3, p0, Lcom/tencent/mm/sdk/openapi/WXApiImplV10;->appId:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    iput-object v2, v0, Lcom/tencent/mm/sdk/channel/MMessageActV2$Args;->content:Ljava/lang/String;

    .line 276
    const-string/jumbo v2, "com.tencent.mm"

    iput-object v2, v0, Lcom/tencent/mm/sdk/channel/MMessageActV2$Args;->targetPkgName:Ljava/lang/String;

    .line 277
    const-string/jumbo v2, "com.tencent.mm.plugin.base.stub.WXEntryActivity"

    iput-object v2, v0, Lcom/tencent/mm/sdk/channel/MMessageActV2$Args;->targetClassName:Ljava/lang/String;

    .line 279
    iget-object v2, p0, Lcom/tencent/mm/sdk/openapi/WXApiImplV10;->context:Landroid/content/Context;

    invoke-static {v2, v0}, Lcom/tencent/mm/sdk/channel/MMessageActV2;->send(Landroid/content/Context;Lcom/tencent/mm/sdk/channel/MMessageActV2$Args;)Z

    move-result v2

    goto/16 :goto_0
.end method

.method public sendResp(Lcom/tencent/mm/sdk/modelbase/BaseResp;)Z
    .locals 6
    .param p1, "resp"    # Lcom/tencent/mm/sdk/modelbase/BaseResp;

    .prologue
    const/4 v2, 0x0

    .line 324
    iget-boolean v3, p0, Lcom/tencent/mm/sdk/openapi/WXApiImplV10;->detached:Z

    if-eqz v3, :cond_0

    .line 325
    new-instance v2, Ljava/lang/IllegalStateException;

    const-string/jumbo v3, "sendResp fail, WXMsgImpl has been detached"

    invoke-direct {v2, v3}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v2

    .line 328
    :cond_0
    iget-object v3, p0, Lcom/tencent/mm/sdk/openapi/WXApiImplV10;->context:Landroid/content/Context;

    const-string/jumbo v4, "com.tencent.mm"

    iget-boolean v5, p0, Lcom/tencent/mm/sdk/openapi/WXApiImplV10;->checkSignature:Z

    invoke-static {v3, v4, v5}, Lcom/tencent/mm/sdk/openapi/WXApiImplComm;->validateAppSignatureForPackage(Landroid/content/Context;Ljava/lang/String;Z)Z

    move-result v3

    if-nez v3, :cond_1

    .line 329
    const-string/jumbo v3, "MicroMsg.SDK.WXApiImplV10"

    const-string/jumbo v4, "sendResp failed for wechat app signature check failed"

    invoke-static {v3, v4}, Lcom/tencent/mm/sdk/platformtools/Log;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 347
    :goto_0
    return v2

    .line 333
    :cond_1
    invoke-virtual {p1}, Lcom/tencent/mm/sdk/modelbase/BaseResp;->checkArgs()Z

    move-result v3

    if-nez v3, :cond_2

    .line 334
    const-string/jumbo v3, "MicroMsg.SDK.WXApiImplV10"

    const-string/jumbo v4, "sendResp checkArgs fail"

    invoke-static {v3, v4}, Lcom/tencent/mm/sdk/platformtools/Log;->e(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 338
    :cond_2
    new-instance v1, Landroid/os/Bundle;

    invoke-direct {v1}, Landroid/os/Bundle;-><init>()V

    .line 339
    .local v1, "data":Landroid/os/Bundle;
    invoke-virtual {p1, v1}, Lcom/tencent/mm/sdk/modelbase/BaseResp;->toBundle(Landroid/os/Bundle;)V

    .line 341
    new-instance v0, Lcom/tencent/mm/sdk/channel/MMessageActV2$Args;

    invoke-direct {v0}, Lcom/tencent/mm/sdk/channel/MMessageActV2$Args;-><init>()V

    .line 342
    .local v0, "args":Lcom/tencent/mm/sdk/channel/MMessageActV2$Args;
    iput-object v1, v0, Lcom/tencent/mm/sdk/channel/MMessageActV2$Args;->bundle:Landroid/os/Bundle;

    .line 343
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v3, "weixin://sendresp?appid="

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    iget-object v3, p0, Lcom/tencent/mm/sdk/openapi/WXApiImplV10;->appId:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    iput-object v2, v0, Lcom/tencent/mm/sdk/channel/MMessageActV2$Args;->content:Ljava/lang/String;

    .line 344
    const-string/jumbo v2, "com.tencent.mm"

    iput-object v2, v0, Lcom/tencent/mm/sdk/channel/MMessageActV2$Args;->targetPkgName:Ljava/lang/String;

    .line 345
    const-string/jumbo v2, "com.tencent.mm.plugin.base.stub.WXEntryActivity"

    iput-object v2, v0, Lcom/tencent/mm/sdk/channel/MMessageActV2$Args;->targetClassName:Ljava/lang/String;

    .line 347
    iget-object v2, p0, Lcom/tencent/mm/sdk/openapi/WXApiImplV10;->context:Landroid/content/Context;

    invoke-static {v2, v0}, Lcom/tencent/mm/sdk/channel/MMessageActV2;->send(Landroid/content/Context;Lcom/tencent/mm/sdk/channel/MMessageActV2$Args;)Z

    move-result v2

    goto :goto_0
.end method
