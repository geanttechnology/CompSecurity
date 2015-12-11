.class public Lcom/poshmark/utils/sharing/ServerShareMessages;
.super Ljava/lang/Object;
.source "ServerShareMessages.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/poshmark/utils/sharing/ServerShareMessages$1;
    }
.end annotation


# instance fields
.field data:Lcom/poshmark/utils/sharing/ShareMessagesContainer;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 8
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 54
    return-void
.end method


# virtual methods
.method public getBody(Lcom/poshmark/utils/ShareManager$SHARE_TYPE;)Ljava/lang/String;
    .locals 3
    .param p1, "type"    # Lcom/poshmark/utils/ShareManager$SHARE_TYPE;

    .prologue
    .line 344
    const/4 v0, 0x0

    .line 345
    .local v0, "body":Ljava/lang/String;
    sget-object v1, Lcom/poshmark/utils/sharing/ServerShareMessages$1;->$SwitchMap$com$poshmark$utils$ShareManager$SHARE_TYPE:[I

    invoke-virtual {p1}, Lcom/poshmark/utils/ShareManager$SHARE_TYPE;->ordinal()I

    move-result v2

    aget v1, v1, v2

    packed-switch v1, :pswitch_data_0

    .line 387
    :cond_0
    :goto_0
    return-object v0

    .line 347
    :pswitch_0
    iget-object v1, p0, Lcom/poshmark/utils/sharing/ServerShareMessages;->data:Lcom/poshmark/utils/sharing/ShareMessagesContainer;

    if-eqz v1, :cond_0

    iget-object v1, p0, Lcom/poshmark/utils/sharing/ServerShareMessages;->data:Lcom/poshmark/utils/sharing/ShareMessagesContainer;

    iget-object v1, v1, Lcom/poshmark/utils/sharing/ShareMessagesContainer;->fbd:Lcom/poshmark/utils/sharing/share_states/Payload;

    if-eqz v1, :cond_0

    .line 348
    iget-object v1, p0, Lcom/poshmark/utils/sharing/ServerShareMessages;->data:Lcom/poshmark/utils/sharing/ShareMessagesContainer;

    iget-object v1, v1, Lcom/poshmark/utils/sharing/ShareMessagesContainer;->fbd:Lcom/poshmark/utils/sharing/share_states/Payload;

    iget-object v0, v1, Lcom/poshmark/utils/sharing/share_states/Payload;->body:Ljava/lang/String;

    goto :goto_0

    .line 352
    :pswitch_1
    iget-object v1, p0, Lcom/poshmark/utils/sharing/ServerShareMessages;->data:Lcom/poshmark/utils/sharing/ShareMessagesContainer;

    if-eqz v1, :cond_0

    iget-object v1, p0, Lcom/poshmark/utils/sharing/ServerShareMessages;->data:Lcom/poshmark/utils/sharing/ShareMessagesContainer;

    iget-object v1, v1, Lcom/poshmark/utils/sharing/ShareMessagesContainer;->fbm:Lcom/poshmark/utils/sharing/share_states/Payload;

    if-eqz v1, :cond_0

    .line 353
    iget-object v1, p0, Lcom/poshmark/utils/sharing/ServerShareMessages;->data:Lcom/poshmark/utils/sharing/ShareMessagesContainer;

    iget-object v1, v1, Lcom/poshmark/utils/sharing/ShareMessagesContainer;->fbm:Lcom/poshmark/utils/sharing/share_states/Payload;

    iget-object v0, v1, Lcom/poshmark/utils/sharing/share_states/Payload;->body:Ljava/lang/String;

    goto :goto_0

    .line 357
    :pswitch_2
    iget-object v1, p0, Lcom/poshmark/utils/sharing/ServerShareMessages;->data:Lcom/poshmark/utils/sharing/ShareMessagesContainer;

    if-eqz v1, :cond_0

    iget-object v1, p0, Lcom/poshmark/utils/sharing/ServerShareMessages;->data:Lcom/poshmark/utils/sharing/ShareMessagesContainer;

    iget-object v1, v1, Lcom/poshmark/utils/sharing/ShareMessagesContainer;->fb:Lcom/poshmark/utils/sharing/share_states/Payload;

    if-eqz v1, :cond_0

    .line 358
    iget-object v1, p0, Lcom/poshmark/utils/sharing/ServerShareMessages;->data:Lcom/poshmark/utils/sharing/ShareMessagesContainer;

    iget-object v1, v1, Lcom/poshmark/utils/sharing/ShareMessagesContainer;->fb:Lcom/poshmark/utils/sharing/share_states/Payload;

    iget-object v0, v1, Lcom/poshmark/utils/sharing/share_states/Payload;->body:Ljava/lang/String;

    goto :goto_0

    .line 362
    :pswitch_3
    iget-object v1, p0, Lcom/poshmark/utils/sharing/ServerShareMessages;->data:Lcom/poshmark/utils/sharing/ShareMessagesContainer;

    if-eqz v1, :cond_0

    iget-object v1, p0, Lcom/poshmark/utils/sharing/ServerShareMessages;->data:Lcom/poshmark/utils/sharing/ShareMessagesContainer;

    iget-object v1, v1, Lcom/poshmark/utils/sharing/ShareMessagesContainer;->tm:Lcom/poshmark/utils/sharing/share_states/Payload;

    if-eqz v1, :cond_0

    .line 363
    iget-object v1, p0, Lcom/poshmark/utils/sharing/ServerShareMessages;->data:Lcom/poshmark/utils/sharing/ShareMessagesContainer;

    iget-object v1, v1, Lcom/poshmark/utils/sharing/ShareMessagesContainer;->tm:Lcom/poshmark/utils/sharing/share_states/Payload;

    iget-object v0, v1, Lcom/poshmark/utils/sharing/share_states/Payload;->body:Ljava/lang/String;

    goto :goto_0

    .line 367
    :pswitch_4
    iget-object v1, p0, Lcom/poshmark/utils/sharing/ServerShareMessages;->data:Lcom/poshmark/utils/sharing/ShareMessagesContainer;

    if-eqz v1, :cond_0

    iget-object v1, p0, Lcom/poshmark/utils/sharing/ServerShareMessages;->data:Lcom/poshmark/utils/sharing/ShareMessagesContainer;

    iget-object v1, v1, Lcom/poshmark/utils/sharing/ShareMessagesContainer;->tw:Lcom/poshmark/utils/sharing/share_states/Payload;

    if-eqz v1, :cond_0

    .line 368
    iget-object v1, p0, Lcom/poshmark/utils/sharing/ServerShareMessages;->data:Lcom/poshmark/utils/sharing/ShareMessagesContainer;

    iget-object v1, v1, Lcom/poshmark/utils/sharing/ShareMessagesContainer;->tw:Lcom/poshmark/utils/sharing/share_states/Payload;

    iget-object v0, v1, Lcom/poshmark/utils/sharing/share_states/Payload;->body:Ljava/lang/String;

    goto :goto_0

    .line 372
    :pswitch_5
    iget-object v1, p0, Lcom/poshmark/utils/sharing/ServerShareMessages;->data:Lcom/poshmark/utils/sharing/ShareMessagesContainer;

    if-eqz v1, :cond_0

    iget-object v1, p0, Lcom/poshmark/utils/sharing/ServerShareMessages;->data:Lcom/poshmark/utils/sharing/ShareMessagesContainer;

    iget-object v1, v1, Lcom/poshmark/utils/sharing/ShareMessagesContainer;->email:Lcom/poshmark/utils/sharing/share_states/Payload;

    if-eqz v1, :cond_0

    .line 373
    iget-object v1, p0, Lcom/poshmark/utils/sharing/ServerShareMessages;->data:Lcom/poshmark/utils/sharing/ShareMessagesContainer;

    iget-object v1, v1, Lcom/poshmark/utils/sharing/ShareMessagesContainer;->email:Lcom/poshmark/utils/sharing/share_states/Payload;

    iget-object v0, v1, Lcom/poshmark/utils/sharing/share_states/Payload;->body:Ljava/lang/String;

    goto :goto_0

    .line 377
    :pswitch_6
    iget-object v1, p0, Lcom/poshmark/utils/sharing/ServerShareMessages;->data:Lcom/poshmark/utils/sharing/ShareMessagesContainer;

    if-eqz v1, :cond_0

    iget-object v1, p0, Lcom/poshmark/utils/sharing/ServerShareMessages;->data:Lcom/poshmark/utils/sharing/ShareMessagesContainer;

    iget-object v1, v1, Lcom/poshmark/utils/sharing/ShareMessagesContainer;->sms:Lcom/poshmark/utils/sharing/share_states/Payload;

    if-eqz v1, :cond_0

    .line 378
    iget-object v1, p0, Lcom/poshmark/utils/sharing/ServerShareMessages;->data:Lcom/poshmark/utils/sharing/ShareMessagesContainer;

    iget-object v1, v1, Lcom/poshmark/utils/sharing/ShareMessagesContainer;->sms:Lcom/poshmark/utils/sharing/share_states/Payload;

    iget-object v0, v1, Lcom/poshmark/utils/sharing/share_states/Payload;->body:Ljava/lang/String;

    goto :goto_0

    .line 382
    :pswitch_7
    iget-object v1, p0, Lcom/poshmark/utils/sharing/ServerShareMessages;->data:Lcom/poshmark/utils/sharing/ShareMessagesContainer;

    if-eqz v1, :cond_0

    iget-object v1, p0, Lcom/poshmark/utils/sharing/ServerShareMessages;->data:Lcom/poshmark/utils/sharing/ShareMessagesContainer;

    iget-object v1, v1, Lcom/poshmark/utils/sharing/ShareMessagesContainer;->pnd:Lcom/poshmark/utils/sharing/share_states/Payload;

    if-eqz v1, :cond_0

    .line 383
    iget-object v1, p0, Lcom/poshmark/utils/sharing/ServerShareMessages;->data:Lcom/poshmark/utils/sharing/ShareMessagesContainer;

    iget-object v1, v1, Lcom/poshmark/utils/sharing/ShareMessagesContainer;->pnd:Lcom/poshmark/utils/sharing/share_states/Payload;

    iget-object v0, v1, Lcom/poshmark/utils/sharing/share_states/Payload;->body:Ljava/lang/String;

    goto/16 :goto_0

    .line 345
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
        :pswitch_2
        :pswitch_3
        :pswitch_4
        :pswitch_5
        :pswitch_6
        :pswitch_7
    .end packed-switch
.end method

.method public getDescription(Lcom/poshmark/utils/ShareManager$SHARE_TYPE;)Ljava/lang/String;
    .locals 3
    .param p1, "type"    # Lcom/poshmark/utils/ShareManager$SHARE_TYPE;

    .prologue
    .line 155
    const/4 v0, 0x0

    .line 156
    .local v0, "msg":Ljava/lang/String;
    sget-object v1, Lcom/poshmark/utils/sharing/ServerShareMessages$1;->$SwitchMap$com$poshmark$utils$ShareManager$SHARE_TYPE:[I

    invoke-virtual {p1}, Lcom/poshmark/utils/ShareManager$SHARE_TYPE;->ordinal()I

    move-result v2

    aget v1, v1, v2

    packed-switch v1, :pswitch_data_0

    .line 198
    :cond_0
    :goto_0
    return-object v0

    .line 158
    :pswitch_0
    iget-object v1, p0, Lcom/poshmark/utils/sharing/ServerShareMessages;->data:Lcom/poshmark/utils/sharing/ShareMessagesContainer;

    if-eqz v1, :cond_0

    iget-object v1, p0, Lcom/poshmark/utils/sharing/ServerShareMessages;->data:Lcom/poshmark/utils/sharing/ShareMessagesContainer;

    iget-object v1, v1, Lcom/poshmark/utils/sharing/ShareMessagesContainer;->fbd:Lcom/poshmark/utils/sharing/share_states/Payload;

    if-eqz v1, :cond_0

    .line 159
    iget-object v1, p0, Lcom/poshmark/utils/sharing/ServerShareMessages;->data:Lcom/poshmark/utils/sharing/ShareMessagesContainer;

    iget-object v1, v1, Lcom/poshmark/utils/sharing/ShareMessagesContainer;->fbd:Lcom/poshmark/utils/sharing/share_states/Payload;

    iget-object v0, v1, Lcom/poshmark/utils/sharing/share_states/Payload;->description:Ljava/lang/String;

    goto :goto_0

    .line 163
    :pswitch_1
    iget-object v1, p0, Lcom/poshmark/utils/sharing/ServerShareMessages;->data:Lcom/poshmark/utils/sharing/ShareMessagesContainer;

    if-eqz v1, :cond_0

    iget-object v1, p0, Lcom/poshmark/utils/sharing/ServerShareMessages;->data:Lcom/poshmark/utils/sharing/ShareMessagesContainer;

    iget-object v1, v1, Lcom/poshmark/utils/sharing/ShareMessagesContainer;->fbm:Lcom/poshmark/utils/sharing/share_states/Payload;

    if-eqz v1, :cond_0

    .line 164
    iget-object v1, p0, Lcom/poshmark/utils/sharing/ServerShareMessages;->data:Lcom/poshmark/utils/sharing/ShareMessagesContainer;

    iget-object v1, v1, Lcom/poshmark/utils/sharing/ShareMessagesContainer;->fbm:Lcom/poshmark/utils/sharing/share_states/Payload;

    iget-object v0, v1, Lcom/poshmark/utils/sharing/share_states/Payload;->description:Ljava/lang/String;

    goto :goto_0

    .line 168
    :pswitch_2
    iget-object v1, p0, Lcom/poshmark/utils/sharing/ServerShareMessages;->data:Lcom/poshmark/utils/sharing/ShareMessagesContainer;

    if-eqz v1, :cond_0

    iget-object v1, p0, Lcom/poshmark/utils/sharing/ServerShareMessages;->data:Lcom/poshmark/utils/sharing/ShareMessagesContainer;

    iget-object v1, v1, Lcom/poshmark/utils/sharing/ShareMessagesContainer;->fb:Lcom/poshmark/utils/sharing/share_states/Payload;

    if-eqz v1, :cond_0

    .line 169
    iget-object v1, p0, Lcom/poshmark/utils/sharing/ServerShareMessages;->data:Lcom/poshmark/utils/sharing/ShareMessagesContainer;

    iget-object v1, v1, Lcom/poshmark/utils/sharing/ShareMessagesContainer;->fb:Lcom/poshmark/utils/sharing/share_states/Payload;

    iget-object v0, v1, Lcom/poshmark/utils/sharing/share_states/Payload;->description:Ljava/lang/String;

    goto :goto_0

    .line 173
    :pswitch_3
    iget-object v1, p0, Lcom/poshmark/utils/sharing/ServerShareMessages;->data:Lcom/poshmark/utils/sharing/ShareMessagesContainer;

    if-eqz v1, :cond_0

    iget-object v1, p0, Lcom/poshmark/utils/sharing/ServerShareMessages;->data:Lcom/poshmark/utils/sharing/ShareMessagesContainer;

    iget-object v1, v1, Lcom/poshmark/utils/sharing/ShareMessagesContainer;->tm:Lcom/poshmark/utils/sharing/share_states/Payload;

    if-eqz v1, :cond_0

    .line 174
    iget-object v1, p0, Lcom/poshmark/utils/sharing/ServerShareMessages;->data:Lcom/poshmark/utils/sharing/ShareMessagesContainer;

    iget-object v1, v1, Lcom/poshmark/utils/sharing/ShareMessagesContainer;->tm:Lcom/poshmark/utils/sharing/share_states/Payload;

    iget-object v0, v1, Lcom/poshmark/utils/sharing/share_states/Payload;->description:Ljava/lang/String;

    goto :goto_0

    .line 178
    :pswitch_4
    iget-object v1, p0, Lcom/poshmark/utils/sharing/ServerShareMessages;->data:Lcom/poshmark/utils/sharing/ShareMessagesContainer;

    if-eqz v1, :cond_0

    iget-object v1, p0, Lcom/poshmark/utils/sharing/ServerShareMessages;->data:Lcom/poshmark/utils/sharing/ShareMessagesContainer;

    iget-object v1, v1, Lcom/poshmark/utils/sharing/ShareMessagesContainer;->tw:Lcom/poshmark/utils/sharing/share_states/Payload;

    if-eqz v1, :cond_0

    .line 179
    iget-object v1, p0, Lcom/poshmark/utils/sharing/ServerShareMessages;->data:Lcom/poshmark/utils/sharing/ShareMessagesContainer;

    iget-object v1, v1, Lcom/poshmark/utils/sharing/ShareMessagesContainer;->tw:Lcom/poshmark/utils/sharing/share_states/Payload;

    iget-object v0, v1, Lcom/poshmark/utils/sharing/share_states/Payload;->description:Ljava/lang/String;

    goto :goto_0

    .line 183
    :pswitch_5
    iget-object v1, p0, Lcom/poshmark/utils/sharing/ServerShareMessages;->data:Lcom/poshmark/utils/sharing/ShareMessagesContainer;

    if-eqz v1, :cond_0

    iget-object v1, p0, Lcom/poshmark/utils/sharing/ServerShareMessages;->data:Lcom/poshmark/utils/sharing/ShareMessagesContainer;

    iget-object v1, v1, Lcom/poshmark/utils/sharing/ShareMessagesContainer;->email:Lcom/poshmark/utils/sharing/share_states/Payload;

    if-eqz v1, :cond_0

    .line 184
    iget-object v1, p0, Lcom/poshmark/utils/sharing/ServerShareMessages;->data:Lcom/poshmark/utils/sharing/ShareMessagesContainer;

    iget-object v1, v1, Lcom/poshmark/utils/sharing/ShareMessagesContainer;->email:Lcom/poshmark/utils/sharing/share_states/Payload;

    iget-object v0, v1, Lcom/poshmark/utils/sharing/share_states/Payload;->description:Ljava/lang/String;

    goto :goto_0

    .line 188
    :pswitch_6
    iget-object v1, p0, Lcom/poshmark/utils/sharing/ServerShareMessages;->data:Lcom/poshmark/utils/sharing/ShareMessagesContainer;

    if-eqz v1, :cond_0

    iget-object v1, p0, Lcom/poshmark/utils/sharing/ServerShareMessages;->data:Lcom/poshmark/utils/sharing/ShareMessagesContainer;

    iget-object v1, v1, Lcom/poshmark/utils/sharing/ShareMessagesContainer;->sms:Lcom/poshmark/utils/sharing/share_states/Payload;

    if-eqz v1, :cond_0

    .line 189
    iget-object v1, p0, Lcom/poshmark/utils/sharing/ServerShareMessages;->data:Lcom/poshmark/utils/sharing/ShareMessagesContainer;

    iget-object v1, v1, Lcom/poshmark/utils/sharing/ShareMessagesContainer;->sms:Lcom/poshmark/utils/sharing/share_states/Payload;

    iget-object v0, v1, Lcom/poshmark/utils/sharing/share_states/Payload;->description:Ljava/lang/String;

    goto :goto_0

    .line 193
    :pswitch_7
    iget-object v1, p0, Lcom/poshmark/utils/sharing/ServerShareMessages;->data:Lcom/poshmark/utils/sharing/ShareMessagesContainer;

    if-eqz v1, :cond_0

    iget-object v1, p0, Lcom/poshmark/utils/sharing/ServerShareMessages;->data:Lcom/poshmark/utils/sharing/ShareMessagesContainer;

    iget-object v1, v1, Lcom/poshmark/utils/sharing/ShareMessagesContainer;->pnd:Lcom/poshmark/utils/sharing/share_states/Payload;

    if-eqz v1, :cond_0

    .line 194
    iget-object v1, p0, Lcom/poshmark/utils/sharing/ServerShareMessages;->data:Lcom/poshmark/utils/sharing/ShareMessagesContainer;

    iget-object v1, v1, Lcom/poshmark/utils/sharing/ShareMessagesContainer;->pnd:Lcom/poshmark/utils/sharing/share_states/Payload;

    iget-object v0, v1, Lcom/poshmark/utils/sharing/share_states/Payload;->description:Ljava/lang/String;

    goto/16 :goto_0

    .line 156
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
        :pswitch_2
        :pswitch_3
        :pswitch_4
        :pswitch_5
        :pswitch_6
        :pswitch_7
    .end packed-switch
.end method

.method public getImageUrl(Lcom/poshmark/utils/ShareManager$SHARE_TYPE;)Ljava/lang/String;
    .locals 3
    .param p1, "type"    # Lcom/poshmark/utils/ShareManager$SHARE_TYPE;

    .prologue
    .line 250
    const/4 v0, 0x0

    .line 251
    .local v0, "url":Ljava/lang/String;
    sget-object v1, Lcom/poshmark/utils/sharing/ServerShareMessages$1;->$SwitchMap$com$poshmark$utils$ShareManager$SHARE_TYPE:[I

    invoke-virtual {p1}, Lcom/poshmark/utils/ShareManager$SHARE_TYPE;->ordinal()I

    move-result v2

    aget v1, v1, v2

    packed-switch v1, :pswitch_data_0

    .line 293
    :cond_0
    :goto_0
    return-object v0

    .line 253
    :pswitch_0
    iget-object v1, p0, Lcom/poshmark/utils/sharing/ServerShareMessages;->data:Lcom/poshmark/utils/sharing/ShareMessagesContainer;

    if-eqz v1, :cond_0

    iget-object v1, p0, Lcom/poshmark/utils/sharing/ServerShareMessages;->data:Lcom/poshmark/utils/sharing/ShareMessagesContainer;

    iget-object v1, v1, Lcom/poshmark/utils/sharing/ShareMessagesContainer;->fbd:Lcom/poshmark/utils/sharing/share_states/Payload;

    if-eqz v1, :cond_0

    .line 254
    iget-object v1, p0, Lcom/poshmark/utils/sharing/ServerShareMessages;->data:Lcom/poshmark/utils/sharing/ShareMessagesContainer;

    iget-object v1, v1, Lcom/poshmark/utils/sharing/ShareMessagesContainer;->fbd:Lcom/poshmark/utils/sharing/share_states/Payload;

    iget-object v0, v1, Lcom/poshmark/utils/sharing/share_states/Payload;->image_url:Ljava/lang/String;

    goto :goto_0

    .line 258
    :pswitch_1
    iget-object v1, p0, Lcom/poshmark/utils/sharing/ServerShareMessages;->data:Lcom/poshmark/utils/sharing/ShareMessagesContainer;

    if-eqz v1, :cond_0

    iget-object v1, p0, Lcom/poshmark/utils/sharing/ServerShareMessages;->data:Lcom/poshmark/utils/sharing/ShareMessagesContainer;

    iget-object v1, v1, Lcom/poshmark/utils/sharing/ShareMessagesContainer;->fbm:Lcom/poshmark/utils/sharing/share_states/Payload;

    if-eqz v1, :cond_0

    .line 259
    iget-object v1, p0, Lcom/poshmark/utils/sharing/ServerShareMessages;->data:Lcom/poshmark/utils/sharing/ShareMessagesContainer;

    iget-object v1, v1, Lcom/poshmark/utils/sharing/ShareMessagesContainer;->fbm:Lcom/poshmark/utils/sharing/share_states/Payload;

    iget-object v0, v1, Lcom/poshmark/utils/sharing/share_states/Payload;->image_url:Ljava/lang/String;

    goto :goto_0

    .line 263
    :pswitch_2
    iget-object v1, p0, Lcom/poshmark/utils/sharing/ServerShareMessages;->data:Lcom/poshmark/utils/sharing/ShareMessagesContainer;

    if-eqz v1, :cond_0

    iget-object v1, p0, Lcom/poshmark/utils/sharing/ServerShareMessages;->data:Lcom/poshmark/utils/sharing/ShareMessagesContainer;

    iget-object v1, v1, Lcom/poshmark/utils/sharing/ShareMessagesContainer;->fb:Lcom/poshmark/utils/sharing/share_states/Payload;

    if-eqz v1, :cond_0

    .line 264
    iget-object v1, p0, Lcom/poshmark/utils/sharing/ServerShareMessages;->data:Lcom/poshmark/utils/sharing/ShareMessagesContainer;

    iget-object v1, v1, Lcom/poshmark/utils/sharing/ShareMessagesContainer;->fb:Lcom/poshmark/utils/sharing/share_states/Payload;

    iget-object v0, v1, Lcom/poshmark/utils/sharing/share_states/Payload;->image_url:Ljava/lang/String;

    goto :goto_0

    .line 268
    :pswitch_3
    iget-object v1, p0, Lcom/poshmark/utils/sharing/ServerShareMessages;->data:Lcom/poshmark/utils/sharing/ShareMessagesContainer;

    if-eqz v1, :cond_0

    iget-object v1, p0, Lcom/poshmark/utils/sharing/ServerShareMessages;->data:Lcom/poshmark/utils/sharing/ShareMessagesContainer;

    iget-object v1, v1, Lcom/poshmark/utils/sharing/ShareMessagesContainer;->tm:Lcom/poshmark/utils/sharing/share_states/Payload;

    if-eqz v1, :cond_0

    .line 269
    iget-object v1, p0, Lcom/poshmark/utils/sharing/ServerShareMessages;->data:Lcom/poshmark/utils/sharing/ShareMessagesContainer;

    iget-object v1, v1, Lcom/poshmark/utils/sharing/ShareMessagesContainer;->tm:Lcom/poshmark/utils/sharing/share_states/Payload;

    iget-object v0, v1, Lcom/poshmark/utils/sharing/share_states/Payload;->image_url:Ljava/lang/String;

    goto :goto_0

    .line 273
    :pswitch_4
    iget-object v1, p0, Lcom/poshmark/utils/sharing/ServerShareMessages;->data:Lcom/poshmark/utils/sharing/ShareMessagesContainer;

    if-eqz v1, :cond_0

    iget-object v1, p0, Lcom/poshmark/utils/sharing/ServerShareMessages;->data:Lcom/poshmark/utils/sharing/ShareMessagesContainer;

    iget-object v1, v1, Lcom/poshmark/utils/sharing/ShareMessagesContainer;->tw:Lcom/poshmark/utils/sharing/share_states/Payload;

    if-eqz v1, :cond_0

    .line 274
    iget-object v1, p0, Lcom/poshmark/utils/sharing/ServerShareMessages;->data:Lcom/poshmark/utils/sharing/ShareMessagesContainer;

    iget-object v1, v1, Lcom/poshmark/utils/sharing/ShareMessagesContainer;->tw:Lcom/poshmark/utils/sharing/share_states/Payload;

    iget-object v0, v1, Lcom/poshmark/utils/sharing/share_states/Payload;->image_url:Ljava/lang/String;

    goto :goto_0

    .line 278
    :pswitch_5
    iget-object v1, p0, Lcom/poshmark/utils/sharing/ServerShareMessages;->data:Lcom/poshmark/utils/sharing/ShareMessagesContainer;

    if-eqz v1, :cond_0

    iget-object v1, p0, Lcom/poshmark/utils/sharing/ServerShareMessages;->data:Lcom/poshmark/utils/sharing/ShareMessagesContainer;

    iget-object v1, v1, Lcom/poshmark/utils/sharing/ShareMessagesContainer;->email:Lcom/poshmark/utils/sharing/share_states/Payload;

    if-eqz v1, :cond_0

    .line 279
    iget-object v1, p0, Lcom/poshmark/utils/sharing/ServerShareMessages;->data:Lcom/poshmark/utils/sharing/ShareMessagesContainer;

    iget-object v1, v1, Lcom/poshmark/utils/sharing/ShareMessagesContainer;->email:Lcom/poshmark/utils/sharing/share_states/Payload;

    iget-object v0, v1, Lcom/poshmark/utils/sharing/share_states/Payload;->image_url:Ljava/lang/String;

    goto :goto_0

    .line 283
    :pswitch_6
    iget-object v1, p0, Lcom/poshmark/utils/sharing/ServerShareMessages;->data:Lcom/poshmark/utils/sharing/ShareMessagesContainer;

    if-eqz v1, :cond_0

    iget-object v1, p0, Lcom/poshmark/utils/sharing/ServerShareMessages;->data:Lcom/poshmark/utils/sharing/ShareMessagesContainer;

    iget-object v1, v1, Lcom/poshmark/utils/sharing/ShareMessagesContainer;->sms:Lcom/poshmark/utils/sharing/share_states/Payload;

    if-eqz v1, :cond_0

    .line 284
    iget-object v1, p0, Lcom/poshmark/utils/sharing/ServerShareMessages;->data:Lcom/poshmark/utils/sharing/ShareMessagesContainer;

    iget-object v1, v1, Lcom/poshmark/utils/sharing/ShareMessagesContainer;->sms:Lcom/poshmark/utils/sharing/share_states/Payload;

    iget-object v0, v1, Lcom/poshmark/utils/sharing/share_states/Payload;->image_url:Ljava/lang/String;

    goto :goto_0

    .line 288
    :pswitch_7
    iget-object v1, p0, Lcom/poshmark/utils/sharing/ServerShareMessages;->data:Lcom/poshmark/utils/sharing/ShareMessagesContainer;

    if-eqz v1, :cond_0

    iget-object v1, p0, Lcom/poshmark/utils/sharing/ServerShareMessages;->data:Lcom/poshmark/utils/sharing/ShareMessagesContainer;

    iget-object v1, v1, Lcom/poshmark/utils/sharing/ShareMessagesContainer;->pnd:Lcom/poshmark/utils/sharing/share_states/Payload;

    if-eqz v1, :cond_0

    .line 289
    iget-object v1, p0, Lcom/poshmark/utils/sharing/ServerShareMessages;->data:Lcom/poshmark/utils/sharing/ShareMessagesContainer;

    iget-object v1, v1, Lcom/poshmark/utils/sharing/ShareMessagesContainer;->pnd:Lcom/poshmark/utils/sharing/share_states/Payload;

    iget-object v0, v1, Lcom/poshmark/utils/sharing/share_states/Payload;->image_url:Ljava/lang/String;

    goto/16 :goto_0

    .line 251
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
        :pswitch_2
        :pswitch_3
        :pswitch_4
        :pswitch_5
        :pswitch_6
        :pswitch_7
    .end packed-switch
.end method

.method public getMessage(Lcom/poshmark/utils/ShareManager$SHARE_TYPE;)Ljava/lang/String;
    .locals 3
    .param p1, "type"    # Lcom/poshmark/utils/ShareManager$SHARE_TYPE;

    .prologue
    .line 13
    const/4 v0, 0x0

    .line 14
    .local v0, "msg":Ljava/lang/String;
    sget-object v1, Lcom/poshmark/utils/sharing/ServerShareMessages$1;->$SwitchMap$com$poshmark$utils$ShareManager$SHARE_TYPE:[I

    invoke-virtual {p1}, Lcom/poshmark/utils/ShareManager$SHARE_TYPE;->ordinal()I

    move-result v2

    aget v1, v1, v2

    packed-switch v1, :pswitch_data_0

    .line 56
    :cond_0
    :goto_0
    return-object v0

    .line 16
    :pswitch_0
    iget-object v1, p0, Lcom/poshmark/utils/sharing/ServerShareMessages;->data:Lcom/poshmark/utils/sharing/ShareMessagesContainer;

    if-eqz v1, :cond_0

    iget-object v1, p0, Lcom/poshmark/utils/sharing/ServerShareMessages;->data:Lcom/poshmark/utils/sharing/ShareMessagesContainer;

    iget-object v1, v1, Lcom/poshmark/utils/sharing/ShareMessagesContainer;->fbd:Lcom/poshmark/utils/sharing/share_states/Payload;

    if-eqz v1, :cond_0

    .line 17
    iget-object v1, p0, Lcom/poshmark/utils/sharing/ServerShareMessages;->data:Lcom/poshmark/utils/sharing/ShareMessagesContainer;

    iget-object v1, v1, Lcom/poshmark/utils/sharing/ShareMessagesContainer;->fbd:Lcom/poshmark/utils/sharing/share_states/Payload;

    iget-object v0, v1, Lcom/poshmark/utils/sharing/share_states/Payload;->message:Ljava/lang/String;

    goto :goto_0

    .line 21
    :pswitch_1
    iget-object v1, p0, Lcom/poshmark/utils/sharing/ServerShareMessages;->data:Lcom/poshmark/utils/sharing/ShareMessagesContainer;

    if-eqz v1, :cond_0

    iget-object v1, p0, Lcom/poshmark/utils/sharing/ServerShareMessages;->data:Lcom/poshmark/utils/sharing/ShareMessagesContainer;

    iget-object v1, v1, Lcom/poshmark/utils/sharing/ShareMessagesContainer;->fbm:Lcom/poshmark/utils/sharing/share_states/Payload;

    if-eqz v1, :cond_0

    .line 22
    iget-object v1, p0, Lcom/poshmark/utils/sharing/ServerShareMessages;->data:Lcom/poshmark/utils/sharing/ShareMessagesContainer;

    iget-object v1, v1, Lcom/poshmark/utils/sharing/ShareMessagesContainer;->fbm:Lcom/poshmark/utils/sharing/share_states/Payload;

    iget-object v0, v1, Lcom/poshmark/utils/sharing/share_states/Payload;->message:Ljava/lang/String;

    goto :goto_0

    .line 26
    :pswitch_2
    iget-object v1, p0, Lcom/poshmark/utils/sharing/ServerShareMessages;->data:Lcom/poshmark/utils/sharing/ShareMessagesContainer;

    if-eqz v1, :cond_0

    iget-object v1, p0, Lcom/poshmark/utils/sharing/ServerShareMessages;->data:Lcom/poshmark/utils/sharing/ShareMessagesContainer;

    iget-object v1, v1, Lcom/poshmark/utils/sharing/ShareMessagesContainer;->fb:Lcom/poshmark/utils/sharing/share_states/Payload;

    if-eqz v1, :cond_0

    .line 27
    iget-object v1, p0, Lcom/poshmark/utils/sharing/ServerShareMessages;->data:Lcom/poshmark/utils/sharing/ShareMessagesContainer;

    iget-object v1, v1, Lcom/poshmark/utils/sharing/ShareMessagesContainer;->fb:Lcom/poshmark/utils/sharing/share_states/Payload;

    iget-object v0, v1, Lcom/poshmark/utils/sharing/share_states/Payload;->message:Ljava/lang/String;

    goto :goto_0

    .line 31
    :pswitch_3
    iget-object v1, p0, Lcom/poshmark/utils/sharing/ServerShareMessages;->data:Lcom/poshmark/utils/sharing/ShareMessagesContainer;

    if-eqz v1, :cond_0

    iget-object v1, p0, Lcom/poshmark/utils/sharing/ServerShareMessages;->data:Lcom/poshmark/utils/sharing/ShareMessagesContainer;

    iget-object v1, v1, Lcom/poshmark/utils/sharing/ShareMessagesContainer;->tm:Lcom/poshmark/utils/sharing/share_states/Payload;

    if-eqz v1, :cond_0

    .line 32
    iget-object v1, p0, Lcom/poshmark/utils/sharing/ServerShareMessages;->data:Lcom/poshmark/utils/sharing/ShareMessagesContainer;

    iget-object v1, v1, Lcom/poshmark/utils/sharing/ShareMessagesContainer;->tm:Lcom/poshmark/utils/sharing/share_states/Payload;

    iget-object v0, v1, Lcom/poshmark/utils/sharing/share_states/Payload;->message:Ljava/lang/String;

    goto :goto_0

    .line 36
    :pswitch_4
    iget-object v1, p0, Lcom/poshmark/utils/sharing/ServerShareMessages;->data:Lcom/poshmark/utils/sharing/ShareMessagesContainer;

    if-eqz v1, :cond_0

    iget-object v1, p0, Lcom/poshmark/utils/sharing/ServerShareMessages;->data:Lcom/poshmark/utils/sharing/ShareMessagesContainer;

    iget-object v1, v1, Lcom/poshmark/utils/sharing/ShareMessagesContainer;->tw:Lcom/poshmark/utils/sharing/share_states/Payload;

    if-eqz v1, :cond_0

    .line 37
    iget-object v1, p0, Lcom/poshmark/utils/sharing/ServerShareMessages;->data:Lcom/poshmark/utils/sharing/ShareMessagesContainer;

    iget-object v1, v1, Lcom/poshmark/utils/sharing/ShareMessagesContainer;->tw:Lcom/poshmark/utils/sharing/share_states/Payload;

    iget-object v0, v1, Lcom/poshmark/utils/sharing/share_states/Payload;->message:Ljava/lang/String;

    goto :goto_0

    .line 41
    :pswitch_5
    iget-object v1, p0, Lcom/poshmark/utils/sharing/ServerShareMessages;->data:Lcom/poshmark/utils/sharing/ShareMessagesContainer;

    if-eqz v1, :cond_0

    iget-object v1, p0, Lcom/poshmark/utils/sharing/ServerShareMessages;->data:Lcom/poshmark/utils/sharing/ShareMessagesContainer;

    iget-object v1, v1, Lcom/poshmark/utils/sharing/ShareMessagesContainer;->email:Lcom/poshmark/utils/sharing/share_states/Payload;

    if-eqz v1, :cond_0

    .line 42
    iget-object v1, p0, Lcom/poshmark/utils/sharing/ServerShareMessages;->data:Lcom/poshmark/utils/sharing/ShareMessagesContainer;

    iget-object v1, v1, Lcom/poshmark/utils/sharing/ShareMessagesContainer;->email:Lcom/poshmark/utils/sharing/share_states/Payload;

    iget-object v0, v1, Lcom/poshmark/utils/sharing/share_states/Payload;->message:Ljava/lang/String;

    goto :goto_0

    .line 46
    :pswitch_6
    iget-object v1, p0, Lcom/poshmark/utils/sharing/ServerShareMessages;->data:Lcom/poshmark/utils/sharing/ShareMessagesContainer;

    if-eqz v1, :cond_0

    iget-object v1, p0, Lcom/poshmark/utils/sharing/ServerShareMessages;->data:Lcom/poshmark/utils/sharing/ShareMessagesContainer;

    iget-object v1, v1, Lcom/poshmark/utils/sharing/ShareMessagesContainer;->sms:Lcom/poshmark/utils/sharing/share_states/Payload;

    if-eqz v1, :cond_0

    .line 47
    iget-object v1, p0, Lcom/poshmark/utils/sharing/ServerShareMessages;->data:Lcom/poshmark/utils/sharing/ShareMessagesContainer;

    iget-object v1, v1, Lcom/poshmark/utils/sharing/ShareMessagesContainer;->sms:Lcom/poshmark/utils/sharing/share_states/Payload;

    iget-object v0, v1, Lcom/poshmark/utils/sharing/share_states/Payload;->message:Ljava/lang/String;

    goto :goto_0

    .line 51
    :pswitch_7
    iget-object v1, p0, Lcom/poshmark/utils/sharing/ServerShareMessages;->data:Lcom/poshmark/utils/sharing/ShareMessagesContainer;

    if-eqz v1, :cond_0

    iget-object v1, p0, Lcom/poshmark/utils/sharing/ServerShareMessages;->data:Lcom/poshmark/utils/sharing/ShareMessagesContainer;

    iget-object v1, v1, Lcom/poshmark/utils/sharing/ShareMessagesContainer;->pnd:Lcom/poshmark/utils/sharing/share_states/Payload;

    if-eqz v1, :cond_0

    .line 52
    iget-object v1, p0, Lcom/poshmark/utils/sharing/ServerShareMessages;->data:Lcom/poshmark/utils/sharing/ShareMessagesContainer;

    iget-object v1, v1, Lcom/poshmark/utils/sharing/ShareMessagesContainer;->pnd:Lcom/poshmark/utils/sharing/share_states/Payload;

    iget-object v0, v1, Lcom/poshmark/utils/sharing/share_states/Payload;->message:Ljava/lang/String;

    goto/16 :goto_0

    .line 14
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
        :pswitch_2
        :pswitch_3
        :pswitch_4
        :pswitch_5
        :pswitch_6
        :pswitch_7
    .end packed-switch
.end method

.method public getPlaceHolder(Lcom/poshmark/utils/ShareManager$SHARE_TYPE;)Ljava/lang/String;
    .locals 3
    .param p1, "type"    # Lcom/poshmark/utils/ShareManager$SHARE_TYPE;

    .prologue
    .line 60
    const/4 v0, 0x0

    .line 61
    .local v0, "msg":Ljava/lang/String;
    sget-object v1, Lcom/poshmark/utils/sharing/ServerShareMessages$1;->$SwitchMap$com$poshmark$utils$ShareManager$SHARE_TYPE:[I

    invoke-virtual {p1}, Lcom/poshmark/utils/ShareManager$SHARE_TYPE;->ordinal()I

    move-result v2

    aget v1, v1, v2

    packed-switch v1, :pswitch_data_0

    .line 103
    :cond_0
    :goto_0
    return-object v0

    .line 63
    :pswitch_0
    iget-object v1, p0, Lcom/poshmark/utils/sharing/ServerShareMessages;->data:Lcom/poshmark/utils/sharing/ShareMessagesContainer;

    if-eqz v1, :cond_0

    iget-object v1, p0, Lcom/poshmark/utils/sharing/ServerShareMessages;->data:Lcom/poshmark/utils/sharing/ShareMessagesContainer;

    iget-object v1, v1, Lcom/poshmark/utils/sharing/ShareMessagesContainer;->fbd:Lcom/poshmark/utils/sharing/share_states/Payload;

    if-eqz v1, :cond_0

    .line 64
    iget-object v1, p0, Lcom/poshmark/utils/sharing/ServerShareMessages;->data:Lcom/poshmark/utils/sharing/ShareMessagesContainer;

    iget-object v1, v1, Lcom/poshmark/utils/sharing/ShareMessagesContainer;->fbd:Lcom/poshmark/utils/sharing/share_states/Payload;

    iget-object v0, v1, Lcom/poshmark/utils/sharing/share_states/Payload;->placeholder:Ljava/lang/String;

    goto :goto_0

    .line 68
    :pswitch_1
    iget-object v1, p0, Lcom/poshmark/utils/sharing/ServerShareMessages;->data:Lcom/poshmark/utils/sharing/ShareMessagesContainer;

    if-eqz v1, :cond_0

    iget-object v1, p0, Lcom/poshmark/utils/sharing/ServerShareMessages;->data:Lcom/poshmark/utils/sharing/ShareMessagesContainer;

    iget-object v1, v1, Lcom/poshmark/utils/sharing/ShareMessagesContainer;->fbm:Lcom/poshmark/utils/sharing/share_states/Payload;

    if-eqz v1, :cond_0

    .line 69
    iget-object v1, p0, Lcom/poshmark/utils/sharing/ServerShareMessages;->data:Lcom/poshmark/utils/sharing/ShareMessagesContainer;

    iget-object v1, v1, Lcom/poshmark/utils/sharing/ShareMessagesContainer;->fbm:Lcom/poshmark/utils/sharing/share_states/Payload;

    iget-object v0, v1, Lcom/poshmark/utils/sharing/share_states/Payload;->placeholder:Ljava/lang/String;

    goto :goto_0

    .line 73
    :pswitch_2
    iget-object v1, p0, Lcom/poshmark/utils/sharing/ServerShareMessages;->data:Lcom/poshmark/utils/sharing/ShareMessagesContainer;

    if-eqz v1, :cond_0

    iget-object v1, p0, Lcom/poshmark/utils/sharing/ServerShareMessages;->data:Lcom/poshmark/utils/sharing/ShareMessagesContainer;

    iget-object v1, v1, Lcom/poshmark/utils/sharing/ShareMessagesContainer;->fb:Lcom/poshmark/utils/sharing/share_states/Payload;

    if-eqz v1, :cond_0

    .line 74
    iget-object v1, p0, Lcom/poshmark/utils/sharing/ServerShareMessages;->data:Lcom/poshmark/utils/sharing/ShareMessagesContainer;

    iget-object v1, v1, Lcom/poshmark/utils/sharing/ShareMessagesContainer;->fb:Lcom/poshmark/utils/sharing/share_states/Payload;

    iget-object v0, v1, Lcom/poshmark/utils/sharing/share_states/Payload;->placeholder:Ljava/lang/String;

    goto :goto_0

    .line 78
    :pswitch_3
    iget-object v1, p0, Lcom/poshmark/utils/sharing/ServerShareMessages;->data:Lcom/poshmark/utils/sharing/ShareMessagesContainer;

    if-eqz v1, :cond_0

    iget-object v1, p0, Lcom/poshmark/utils/sharing/ServerShareMessages;->data:Lcom/poshmark/utils/sharing/ShareMessagesContainer;

    iget-object v1, v1, Lcom/poshmark/utils/sharing/ShareMessagesContainer;->tm:Lcom/poshmark/utils/sharing/share_states/Payload;

    if-eqz v1, :cond_0

    .line 79
    iget-object v1, p0, Lcom/poshmark/utils/sharing/ServerShareMessages;->data:Lcom/poshmark/utils/sharing/ShareMessagesContainer;

    iget-object v1, v1, Lcom/poshmark/utils/sharing/ShareMessagesContainer;->tm:Lcom/poshmark/utils/sharing/share_states/Payload;

    iget-object v0, v1, Lcom/poshmark/utils/sharing/share_states/Payload;->placeholder:Ljava/lang/String;

    goto :goto_0

    .line 83
    :pswitch_4
    iget-object v1, p0, Lcom/poshmark/utils/sharing/ServerShareMessages;->data:Lcom/poshmark/utils/sharing/ShareMessagesContainer;

    if-eqz v1, :cond_0

    iget-object v1, p0, Lcom/poshmark/utils/sharing/ServerShareMessages;->data:Lcom/poshmark/utils/sharing/ShareMessagesContainer;

    iget-object v1, v1, Lcom/poshmark/utils/sharing/ShareMessagesContainer;->tw:Lcom/poshmark/utils/sharing/share_states/Payload;

    if-eqz v1, :cond_0

    .line 84
    iget-object v1, p0, Lcom/poshmark/utils/sharing/ServerShareMessages;->data:Lcom/poshmark/utils/sharing/ShareMessagesContainer;

    iget-object v1, v1, Lcom/poshmark/utils/sharing/ShareMessagesContainer;->tw:Lcom/poshmark/utils/sharing/share_states/Payload;

    iget-object v0, v1, Lcom/poshmark/utils/sharing/share_states/Payload;->placeholder:Ljava/lang/String;

    goto :goto_0

    .line 88
    :pswitch_5
    iget-object v1, p0, Lcom/poshmark/utils/sharing/ServerShareMessages;->data:Lcom/poshmark/utils/sharing/ShareMessagesContainer;

    if-eqz v1, :cond_0

    iget-object v1, p0, Lcom/poshmark/utils/sharing/ServerShareMessages;->data:Lcom/poshmark/utils/sharing/ShareMessagesContainer;

    iget-object v1, v1, Lcom/poshmark/utils/sharing/ShareMessagesContainer;->email:Lcom/poshmark/utils/sharing/share_states/Payload;

    if-eqz v1, :cond_0

    .line 89
    iget-object v1, p0, Lcom/poshmark/utils/sharing/ServerShareMessages;->data:Lcom/poshmark/utils/sharing/ShareMessagesContainer;

    iget-object v1, v1, Lcom/poshmark/utils/sharing/ShareMessagesContainer;->email:Lcom/poshmark/utils/sharing/share_states/Payload;

    iget-object v0, v1, Lcom/poshmark/utils/sharing/share_states/Payload;->placeholder:Ljava/lang/String;

    goto :goto_0

    .line 93
    :pswitch_6
    iget-object v1, p0, Lcom/poshmark/utils/sharing/ServerShareMessages;->data:Lcom/poshmark/utils/sharing/ShareMessagesContainer;

    if-eqz v1, :cond_0

    iget-object v1, p0, Lcom/poshmark/utils/sharing/ServerShareMessages;->data:Lcom/poshmark/utils/sharing/ShareMessagesContainer;

    iget-object v1, v1, Lcom/poshmark/utils/sharing/ShareMessagesContainer;->sms:Lcom/poshmark/utils/sharing/share_states/Payload;

    if-eqz v1, :cond_0

    .line 94
    iget-object v1, p0, Lcom/poshmark/utils/sharing/ServerShareMessages;->data:Lcom/poshmark/utils/sharing/ShareMessagesContainer;

    iget-object v1, v1, Lcom/poshmark/utils/sharing/ShareMessagesContainer;->sms:Lcom/poshmark/utils/sharing/share_states/Payload;

    iget-object v0, v1, Lcom/poshmark/utils/sharing/share_states/Payload;->placeholder:Ljava/lang/String;

    goto :goto_0

    .line 98
    :pswitch_7
    iget-object v1, p0, Lcom/poshmark/utils/sharing/ServerShareMessages;->data:Lcom/poshmark/utils/sharing/ShareMessagesContainer;

    if-eqz v1, :cond_0

    iget-object v1, p0, Lcom/poshmark/utils/sharing/ServerShareMessages;->data:Lcom/poshmark/utils/sharing/ShareMessagesContainer;

    iget-object v1, v1, Lcom/poshmark/utils/sharing/ShareMessagesContainer;->pnd:Lcom/poshmark/utils/sharing/share_states/Payload;

    if-eqz v1, :cond_0

    .line 99
    iget-object v1, p0, Lcom/poshmark/utils/sharing/ServerShareMessages;->data:Lcom/poshmark/utils/sharing/ShareMessagesContainer;

    iget-object v1, v1, Lcom/poshmark/utils/sharing/ShareMessagesContainer;->pnd:Lcom/poshmark/utils/sharing/share_states/Payload;

    iget-object v0, v1, Lcom/poshmark/utils/sharing/share_states/Payload;->placeholder:Ljava/lang/String;

    goto/16 :goto_0

    .line 61
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
        :pswitch_2
        :pswitch_3
        :pswitch_4
        :pswitch_5
        :pswitch_6
        :pswitch_7
    .end packed-switch
.end method

.method public getSubject(Lcom/poshmark/utils/ShareManager$SHARE_TYPE;)Ljava/lang/String;
    .locals 3
    .param p1, "type"    # Lcom/poshmark/utils/ShareManager$SHARE_TYPE;

    .prologue
    .line 297
    const/4 v0, 0x0

    .line 298
    .local v0, "subject":Ljava/lang/String;
    sget-object v1, Lcom/poshmark/utils/sharing/ServerShareMessages$1;->$SwitchMap$com$poshmark$utils$ShareManager$SHARE_TYPE:[I

    invoke-virtual {p1}, Lcom/poshmark/utils/ShareManager$SHARE_TYPE;->ordinal()I

    move-result v2

    aget v1, v1, v2

    packed-switch v1, :pswitch_data_0

    .line 340
    :cond_0
    :goto_0
    return-object v0

    .line 300
    :pswitch_0
    iget-object v1, p0, Lcom/poshmark/utils/sharing/ServerShareMessages;->data:Lcom/poshmark/utils/sharing/ShareMessagesContainer;

    if-eqz v1, :cond_0

    iget-object v1, p0, Lcom/poshmark/utils/sharing/ServerShareMessages;->data:Lcom/poshmark/utils/sharing/ShareMessagesContainer;

    iget-object v1, v1, Lcom/poshmark/utils/sharing/ShareMessagesContainer;->fbd:Lcom/poshmark/utils/sharing/share_states/Payload;

    if-eqz v1, :cond_0

    .line 301
    iget-object v1, p0, Lcom/poshmark/utils/sharing/ServerShareMessages;->data:Lcom/poshmark/utils/sharing/ShareMessagesContainer;

    iget-object v1, v1, Lcom/poshmark/utils/sharing/ShareMessagesContainer;->fbd:Lcom/poshmark/utils/sharing/share_states/Payload;

    iget-object v0, v1, Lcom/poshmark/utils/sharing/share_states/Payload;->subject:Ljava/lang/String;

    goto :goto_0

    .line 305
    :pswitch_1
    iget-object v1, p0, Lcom/poshmark/utils/sharing/ServerShareMessages;->data:Lcom/poshmark/utils/sharing/ShareMessagesContainer;

    if-eqz v1, :cond_0

    iget-object v1, p0, Lcom/poshmark/utils/sharing/ServerShareMessages;->data:Lcom/poshmark/utils/sharing/ShareMessagesContainer;

    iget-object v1, v1, Lcom/poshmark/utils/sharing/ShareMessagesContainer;->fbm:Lcom/poshmark/utils/sharing/share_states/Payload;

    if-eqz v1, :cond_0

    .line 306
    iget-object v1, p0, Lcom/poshmark/utils/sharing/ServerShareMessages;->data:Lcom/poshmark/utils/sharing/ShareMessagesContainer;

    iget-object v1, v1, Lcom/poshmark/utils/sharing/ShareMessagesContainer;->fbm:Lcom/poshmark/utils/sharing/share_states/Payload;

    iget-object v0, v1, Lcom/poshmark/utils/sharing/share_states/Payload;->subject:Ljava/lang/String;

    goto :goto_0

    .line 310
    :pswitch_2
    iget-object v1, p0, Lcom/poshmark/utils/sharing/ServerShareMessages;->data:Lcom/poshmark/utils/sharing/ShareMessagesContainer;

    if-eqz v1, :cond_0

    iget-object v1, p0, Lcom/poshmark/utils/sharing/ServerShareMessages;->data:Lcom/poshmark/utils/sharing/ShareMessagesContainer;

    iget-object v1, v1, Lcom/poshmark/utils/sharing/ShareMessagesContainer;->fb:Lcom/poshmark/utils/sharing/share_states/Payload;

    if-eqz v1, :cond_0

    .line 311
    iget-object v1, p0, Lcom/poshmark/utils/sharing/ServerShareMessages;->data:Lcom/poshmark/utils/sharing/ShareMessagesContainer;

    iget-object v1, v1, Lcom/poshmark/utils/sharing/ShareMessagesContainer;->fb:Lcom/poshmark/utils/sharing/share_states/Payload;

    iget-object v0, v1, Lcom/poshmark/utils/sharing/share_states/Payload;->subject:Ljava/lang/String;

    goto :goto_0

    .line 315
    :pswitch_3
    iget-object v1, p0, Lcom/poshmark/utils/sharing/ServerShareMessages;->data:Lcom/poshmark/utils/sharing/ShareMessagesContainer;

    if-eqz v1, :cond_0

    iget-object v1, p0, Lcom/poshmark/utils/sharing/ServerShareMessages;->data:Lcom/poshmark/utils/sharing/ShareMessagesContainer;

    iget-object v1, v1, Lcom/poshmark/utils/sharing/ShareMessagesContainer;->tm:Lcom/poshmark/utils/sharing/share_states/Payload;

    if-eqz v1, :cond_0

    .line 316
    iget-object v1, p0, Lcom/poshmark/utils/sharing/ServerShareMessages;->data:Lcom/poshmark/utils/sharing/ShareMessagesContainer;

    iget-object v1, v1, Lcom/poshmark/utils/sharing/ShareMessagesContainer;->tm:Lcom/poshmark/utils/sharing/share_states/Payload;

    iget-object v0, v1, Lcom/poshmark/utils/sharing/share_states/Payload;->subject:Ljava/lang/String;

    goto :goto_0

    .line 320
    :pswitch_4
    iget-object v1, p0, Lcom/poshmark/utils/sharing/ServerShareMessages;->data:Lcom/poshmark/utils/sharing/ShareMessagesContainer;

    if-eqz v1, :cond_0

    iget-object v1, p0, Lcom/poshmark/utils/sharing/ServerShareMessages;->data:Lcom/poshmark/utils/sharing/ShareMessagesContainer;

    iget-object v1, v1, Lcom/poshmark/utils/sharing/ShareMessagesContainer;->tw:Lcom/poshmark/utils/sharing/share_states/Payload;

    if-eqz v1, :cond_0

    .line 321
    iget-object v1, p0, Lcom/poshmark/utils/sharing/ServerShareMessages;->data:Lcom/poshmark/utils/sharing/ShareMessagesContainer;

    iget-object v1, v1, Lcom/poshmark/utils/sharing/ShareMessagesContainer;->tw:Lcom/poshmark/utils/sharing/share_states/Payload;

    iget-object v0, v1, Lcom/poshmark/utils/sharing/share_states/Payload;->subject:Ljava/lang/String;

    goto :goto_0

    .line 325
    :pswitch_5
    iget-object v1, p0, Lcom/poshmark/utils/sharing/ServerShareMessages;->data:Lcom/poshmark/utils/sharing/ShareMessagesContainer;

    if-eqz v1, :cond_0

    iget-object v1, p0, Lcom/poshmark/utils/sharing/ServerShareMessages;->data:Lcom/poshmark/utils/sharing/ShareMessagesContainer;

    iget-object v1, v1, Lcom/poshmark/utils/sharing/ShareMessagesContainer;->email:Lcom/poshmark/utils/sharing/share_states/Payload;

    if-eqz v1, :cond_0

    .line 326
    iget-object v1, p0, Lcom/poshmark/utils/sharing/ServerShareMessages;->data:Lcom/poshmark/utils/sharing/ShareMessagesContainer;

    iget-object v1, v1, Lcom/poshmark/utils/sharing/ShareMessagesContainer;->email:Lcom/poshmark/utils/sharing/share_states/Payload;

    iget-object v0, v1, Lcom/poshmark/utils/sharing/share_states/Payload;->subject:Ljava/lang/String;

    goto :goto_0

    .line 330
    :pswitch_6
    iget-object v1, p0, Lcom/poshmark/utils/sharing/ServerShareMessages;->data:Lcom/poshmark/utils/sharing/ShareMessagesContainer;

    if-eqz v1, :cond_0

    iget-object v1, p0, Lcom/poshmark/utils/sharing/ServerShareMessages;->data:Lcom/poshmark/utils/sharing/ShareMessagesContainer;

    iget-object v1, v1, Lcom/poshmark/utils/sharing/ShareMessagesContainer;->sms:Lcom/poshmark/utils/sharing/share_states/Payload;

    if-eqz v1, :cond_0

    .line 331
    iget-object v1, p0, Lcom/poshmark/utils/sharing/ServerShareMessages;->data:Lcom/poshmark/utils/sharing/ShareMessagesContainer;

    iget-object v1, v1, Lcom/poshmark/utils/sharing/ShareMessagesContainer;->sms:Lcom/poshmark/utils/sharing/share_states/Payload;

    iget-object v0, v1, Lcom/poshmark/utils/sharing/share_states/Payload;->subject:Ljava/lang/String;

    goto :goto_0

    .line 335
    :pswitch_7
    iget-object v1, p0, Lcom/poshmark/utils/sharing/ServerShareMessages;->data:Lcom/poshmark/utils/sharing/ShareMessagesContainer;

    if-eqz v1, :cond_0

    iget-object v1, p0, Lcom/poshmark/utils/sharing/ServerShareMessages;->data:Lcom/poshmark/utils/sharing/ShareMessagesContainer;

    iget-object v1, v1, Lcom/poshmark/utils/sharing/ShareMessagesContainer;->pnd:Lcom/poshmark/utils/sharing/share_states/Payload;

    if-eqz v1, :cond_0

    .line 336
    iget-object v1, p0, Lcom/poshmark/utils/sharing/ServerShareMessages;->data:Lcom/poshmark/utils/sharing/ShareMessagesContainer;

    iget-object v1, v1, Lcom/poshmark/utils/sharing/ShareMessagesContainer;->pnd:Lcom/poshmark/utils/sharing/share_states/Payload;

    iget-object v0, v1, Lcom/poshmark/utils/sharing/share_states/Payload;->subject:Ljava/lang/String;

    goto/16 :goto_0

    .line 298
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
        :pswitch_2
        :pswitch_3
        :pswitch_4
        :pswitch_5
        :pswitch_6
        :pswitch_7
    .end packed-switch
.end method

.method public getTitle(Lcom/poshmark/utils/ShareManager$SHARE_TYPE;)Ljava/lang/String;
    .locals 3
    .param p1, "type"    # Lcom/poshmark/utils/ShareManager$SHARE_TYPE;

    .prologue
    .line 107
    const/4 v0, 0x0

    .line 108
    .local v0, "msg":Ljava/lang/String;
    sget-object v1, Lcom/poshmark/utils/sharing/ServerShareMessages$1;->$SwitchMap$com$poshmark$utils$ShareManager$SHARE_TYPE:[I

    invoke-virtual {p1}, Lcom/poshmark/utils/ShareManager$SHARE_TYPE;->ordinal()I

    move-result v2

    aget v1, v1, v2

    packed-switch v1, :pswitch_data_0

    .line 150
    :cond_0
    :goto_0
    return-object v0

    .line 110
    :pswitch_0
    iget-object v1, p0, Lcom/poshmark/utils/sharing/ServerShareMessages;->data:Lcom/poshmark/utils/sharing/ShareMessagesContainer;

    if-eqz v1, :cond_0

    iget-object v1, p0, Lcom/poshmark/utils/sharing/ServerShareMessages;->data:Lcom/poshmark/utils/sharing/ShareMessagesContainer;

    iget-object v1, v1, Lcom/poshmark/utils/sharing/ShareMessagesContainer;->fbd:Lcom/poshmark/utils/sharing/share_states/Payload;

    if-eqz v1, :cond_0

    .line 111
    iget-object v1, p0, Lcom/poshmark/utils/sharing/ServerShareMessages;->data:Lcom/poshmark/utils/sharing/ShareMessagesContainer;

    iget-object v1, v1, Lcom/poshmark/utils/sharing/ShareMessagesContainer;->fbd:Lcom/poshmark/utils/sharing/share_states/Payload;

    iget-object v0, v1, Lcom/poshmark/utils/sharing/share_states/Payload;->title:Ljava/lang/String;

    goto :goto_0

    .line 115
    :pswitch_1
    iget-object v1, p0, Lcom/poshmark/utils/sharing/ServerShareMessages;->data:Lcom/poshmark/utils/sharing/ShareMessagesContainer;

    if-eqz v1, :cond_0

    iget-object v1, p0, Lcom/poshmark/utils/sharing/ServerShareMessages;->data:Lcom/poshmark/utils/sharing/ShareMessagesContainer;

    iget-object v1, v1, Lcom/poshmark/utils/sharing/ShareMessagesContainer;->fbm:Lcom/poshmark/utils/sharing/share_states/Payload;

    if-eqz v1, :cond_0

    .line 116
    iget-object v1, p0, Lcom/poshmark/utils/sharing/ServerShareMessages;->data:Lcom/poshmark/utils/sharing/ShareMessagesContainer;

    iget-object v1, v1, Lcom/poshmark/utils/sharing/ShareMessagesContainer;->fbm:Lcom/poshmark/utils/sharing/share_states/Payload;

    iget-object v0, v1, Lcom/poshmark/utils/sharing/share_states/Payload;->title:Ljava/lang/String;

    goto :goto_0

    .line 120
    :pswitch_2
    iget-object v1, p0, Lcom/poshmark/utils/sharing/ServerShareMessages;->data:Lcom/poshmark/utils/sharing/ShareMessagesContainer;

    if-eqz v1, :cond_0

    iget-object v1, p0, Lcom/poshmark/utils/sharing/ServerShareMessages;->data:Lcom/poshmark/utils/sharing/ShareMessagesContainer;

    iget-object v1, v1, Lcom/poshmark/utils/sharing/ShareMessagesContainer;->fb:Lcom/poshmark/utils/sharing/share_states/Payload;

    if-eqz v1, :cond_0

    .line 121
    iget-object v1, p0, Lcom/poshmark/utils/sharing/ServerShareMessages;->data:Lcom/poshmark/utils/sharing/ShareMessagesContainer;

    iget-object v1, v1, Lcom/poshmark/utils/sharing/ShareMessagesContainer;->fb:Lcom/poshmark/utils/sharing/share_states/Payload;

    iget-object v0, v1, Lcom/poshmark/utils/sharing/share_states/Payload;->title:Ljava/lang/String;

    goto :goto_0

    .line 125
    :pswitch_3
    iget-object v1, p0, Lcom/poshmark/utils/sharing/ServerShareMessages;->data:Lcom/poshmark/utils/sharing/ShareMessagesContainer;

    if-eqz v1, :cond_0

    iget-object v1, p0, Lcom/poshmark/utils/sharing/ServerShareMessages;->data:Lcom/poshmark/utils/sharing/ShareMessagesContainer;

    iget-object v1, v1, Lcom/poshmark/utils/sharing/ShareMessagesContainer;->tm:Lcom/poshmark/utils/sharing/share_states/Payload;

    if-eqz v1, :cond_0

    .line 126
    iget-object v1, p0, Lcom/poshmark/utils/sharing/ServerShareMessages;->data:Lcom/poshmark/utils/sharing/ShareMessagesContainer;

    iget-object v1, v1, Lcom/poshmark/utils/sharing/ShareMessagesContainer;->tm:Lcom/poshmark/utils/sharing/share_states/Payload;

    iget-object v0, v1, Lcom/poshmark/utils/sharing/share_states/Payload;->title:Ljava/lang/String;

    goto :goto_0

    .line 130
    :pswitch_4
    iget-object v1, p0, Lcom/poshmark/utils/sharing/ServerShareMessages;->data:Lcom/poshmark/utils/sharing/ShareMessagesContainer;

    if-eqz v1, :cond_0

    iget-object v1, p0, Lcom/poshmark/utils/sharing/ServerShareMessages;->data:Lcom/poshmark/utils/sharing/ShareMessagesContainer;

    iget-object v1, v1, Lcom/poshmark/utils/sharing/ShareMessagesContainer;->tw:Lcom/poshmark/utils/sharing/share_states/Payload;

    if-eqz v1, :cond_0

    .line 131
    iget-object v1, p0, Lcom/poshmark/utils/sharing/ServerShareMessages;->data:Lcom/poshmark/utils/sharing/ShareMessagesContainer;

    iget-object v1, v1, Lcom/poshmark/utils/sharing/ShareMessagesContainer;->tw:Lcom/poshmark/utils/sharing/share_states/Payload;

    iget-object v0, v1, Lcom/poshmark/utils/sharing/share_states/Payload;->title:Ljava/lang/String;

    goto :goto_0

    .line 135
    :pswitch_5
    iget-object v1, p0, Lcom/poshmark/utils/sharing/ServerShareMessages;->data:Lcom/poshmark/utils/sharing/ShareMessagesContainer;

    if-eqz v1, :cond_0

    iget-object v1, p0, Lcom/poshmark/utils/sharing/ServerShareMessages;->data:Lcom/poshmark/utils/sharing/ShareMessagesContainer;

    iget-object v1, v1, Lcom/poshmark/utils/sharing/ShareMessagesContainer;->email:Lcom/poshmark/utils/sharing/share_states/Payload;

    if-eqz v1, :cond_0

    .line 136
    iget-object v1, p0, Lcom/poshmark/utils/sharing/ServerShareMessages;->data:Lcom/poshmark/utils/sharing/ShareMessagesContainer;

    iget-object v1, v1, Lcom/poshmark/utils/sharing/ShareMessagesContainer;->email:Lcom/poshmark/utils/sharing/share_states/Payload;

    iget-object v0, v1, Lcom/poshmark/utils/sharing/share_states/Payload;->title:Ljava/lang/String;

    goto :goto_0

    .line 140
    :pswitch_6
    iget-object v1, p0, Lcom/poshmark/utils/sharing/ServerShareMessages;->data:Lcom/poshmark/utils/sharing/ShareMessagesContainer;

    if-eqz v1, :cond_0

    iget-object v1, p0, Lcom/poshmark/utils/sharing/ServerShareMessages;->data:Lcom/poshmark/utils/sharing/ShareMessagesContainer;

    iget-object v1, v1, Lcom/poshmark/utils/sharing/ShareMessagesContainer;->sms:Lcom/poshmark/utils/sharing/share_states/Payload;

    if-eqz v1, :cond_0

    .line 141
    iget-object v1, p0, Lcom/poshmark/utils/sharing/ServerShareMessages;->data:Lcom/poshmark/utils/sharing/ShareMessagesContainer;

    iget-object v1, v1, Lcom/poshmark/utils/sharing/ShareMessagesContainer;->sms:Lcom/poshmark/utils/sharing/share_states/Payload;

    iget-object v0, v1, Lcom/poshmark/utils/sharing/share_states/Payload;->title:Ljava/lang/String;

    goto :goto_0

    .line 145
    :pswitch_7
    iget-object v1, p0, Lcom/poshmark/utils/sharing/ServerShareMessages;->data:Lcom/poshmark/utils/sharing/ShareMessagesContainer;

    if-eqz v1, :cond_0

    iget-object v1, p0, Lcom/poshmark/utils/sharing/ServerShareMessages;->data:Lcom/poshmark/utils/sharing/ShareMessagesContainer;

    iget-object v1, v1, Lcom/poshmark/utils/sharing/ShareMessagesContainer;->pnd:Lcom/poshmark/utils/sharing/share_states/Payload;

    if-eqz v1, :cond_0

    .line 146
    iget-object v1, p0, Lcom/poshmark/utils/sharing/ServerShareMessages;->data:Lcom/poshmark/utils/sharing/ShareMessagesContainer;

    iget-object v1, v1, Lcom/poshmark/utils/sharing/ShareMessagesContainer;->pnd:Lcom/poshmark/utils/sharing/share_states/Payload;

    iget-object v0, v1, Lcom/poshmark/utils/sharing/share_states/Payload;->title:Ljava/lang/String;

    goto/16 :goto_0

    .line 108
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
        :pswitch_2
        :pswitch_3
        :pswitch_4
        :pswitch_5
        :pswitch_6
        :pswitch_7
    .end packed-switch
.end method

.method public getUrl(Lcom/poshmark/utils/ShareManager$SHARE_TYPE;)Ljava/lang/String;
    .locals 3
    .param p1, "type"    # Lcom/poshmark/utils/ShareManager$SHARE_TYPE;

    .prologue
    .line 203
    const/4 v0, 0x0

    .line 204
    .local v0, "url":Ljava/lang/String;
    sget-object v1, Lcom/poshmark/utils/sharing/ServerShareMessages$1;->$SwitchMap$com$poshmark$utils$ShareManager$SHARE_TYPE:[I

    invoke-virtual {p1}, Lcom/poshmark/utils/ShareManager$SHARE_TYPE;->ordinal()I

    move-result v2

    aget v1, v1, v2

    packed-switch v1, :pswitch_data_0

    .line 246
    :cond_0
    :goto_0
    return-object v0

    .line 206
    :pswitch_0
    iget-object v1, p0, Lcom/poshmark/utils/sharing/ServerShareMessages;->data:Lcom/poshmark/utils/sharing/ShareMessagesContainer;

    if-eqz v1, :cond_0

    iget-object v1, p0, Lcom/poshmark/utils/sharing/ServerShareMessages;->data:Lcom/poshmark/utils/sharing/ShareMessagesContainer;

    iget-object v1, v1, Lcom/poshmark/utils/sharing/ShareMessagesContainer;->fbd:Lcom/poshmark/utils/sharing/share_states/Payload;

    if-eqz v1, :cond_0

    .line 207
    iget-object v1, p0, Lcom/poshmark/utils/sharing/ServerShareMessages;->data:Lcom/poshmark/utils/sharing/ShareMessagesContainer;

    iget-object v1, v1, Lcom/poshmark/utils/sharing/ShareMessagesContainer;->fbd:Lcom/poshmark/utils/sharing/share_states/Payload;

    iget-object v0, v1, Lcom/poshmark/utils/sharing/share_states/Payload;->url:Ljava/lang/String;

    goto :goto_0

    .line 211
    :pswitch_1
    iget-object v1, p0, Lcom/poshmark/utils/sharing/ServerShareMessages;->data:Lcom/poshmark/utils/sharing/ShareMessagesContainer;

    if-eqz v1, :cond_0

    iget-object v1, p0, Lcom/poshmark/utils/sharing/ServerShareMessages;->data:Lcom/poshmark/utils/sharing/ShareMessagesContainer;

    iget-object v1, v1, Lcom/poshmark/utils/sharing/ShareMessagesContainer;->fbm:Lcom/poshmark/utils/sharing/share_states/Payload;

    if-eqz v1, :cond_0

    .line 212
    iget-object v1, p0, Lcom/poshmark/utils/sharing/ServerShareMessages;->data:Lcom/poshmark/utils/sharing/ShareMessagesContainer;

    iget-object v1, v1, Lcom/poshmark/utils/sharing/ShareMessagesContainer;->fbm:Lcom/poshmark/utils/sharing/share_states/Payload;

    iget-object v0, v1, Lcom/poshmark/utils/sharing/share_states/Payload;->url:Ljava/lang/String;

    goto :goto_0

    .line 216
    :pswitch_2
    iget-object v1, p0, Lcom/poshmark/utils/sharing/ServerShareMessages;->data:Lcom/poshmark/utils/sharing/ShareMessagesContainer;

    if-eqz v1, :cond_0

    iget-object v1, p0, Lcom/poshmark/utils/sharing/ServerShareMessages;->data:Lcom/poshmark/utils/sharing/ShareMessagesContainer;

    iget-object v1, v1, Lcom/poshmark/utils/sharing/ShareMessagesContainer;->fb:Lcom/poshmark/utils/sharing/share_states/Payload;

    if-eqz v1, :cond_0

    .line 217
    iget-object v1, p0, Lcom/poshmark/utils/sharing/ServerShareMessages;->data:Lcom/poshmark/utils/sharing/ShareMessagesContainer;

    iget-object v1, v1, Lcom/poshmark/utils/sharing/ShareMessagesContainer;->fb:Lcom/poshmark/utils/sharing/share_states/Payload;

    iget-object v0, v1, Lcom/poshmark/utils/sharing/share_states/Payload;->url:Ljava/lang/String;

    goto :goto_0

    .line 221
    :pswitch_3
    iget-object v1, p0, Lcom/poshmark/utils/sharing/ServerShareMessages;->data:Lcom/poshmark/utils/sharing/ShareMessagesContainer;

    if-eqz v1, :cond_0

    iget-object v1, p0, Lcom/poshmark/utils/sharing/ServerShareMessages;->data:Lcom/poshmark/utils/sharing/ShareMessagesContainer;

    iget-object v1, v1, Lcom/poshmark/utils/sharing/ShareMessagesContainer;->tm:Lcom/poshmark/utils/sharing/share_states/Payload;

    if-eqz v1, :cond_0

    .line 222
    iget-object v1, p0, Lcom/poshmark/utils/sharing/ServerShareMessages;->data:Lcom/poshmark/utils/sharing/ShareMessagesContainer;

    iget-object v1, v1, Lcom/poshmark/utils/sharing/ShareMessagesContainer;->tm:Lcom/poshmark/utils/sharing/share_states/Payload;

    iget-object v0, v1, Lcom/poshmark/utils/sharing/share_states/Payload;->url:Ljava/lang/String;

    goto :goto_0

    .line 226
    :pswitch_4
    iget-object v1, p0, Lcom/poshmark/utils/sharing/ServerShareMessages;->data:Lcom/poshmark/utils/sharing/ShareMessagesContainer;

    if-eqz v1, :cond_0

    iget-object v1, p0, Lcom/poshmark/utils/sharing/ServerShareMessages;->data:Lcom/poshmark/utils/sharing/ShareMessagesContainer;

    iget-object v1, v1, Lcom/poshmark/utils/sharing/ShareMessagesContainer;->tw:Lcom/poshmark/utils/sharing/share_states/Payload;

    if-eqz v1, :cond_0

    .line 227
    iget-object v1, p0, Lcom/poshmark/utils/sharing/ServerShareMessages;->data:Lcom/poshmark/utils/sharing/ShareMessagesContainer;

    iget-object v1, v1, Lcom/poshmark/utils/sharing/ShareMessagesContainer;->tw:Lcom/poshmark/utils/sharing/share_states/Payload;

    iget-object v0, v1, Lcom/poshmark/utils/sharing/share_states/Payload;->url:Ljava/lang/String;

    goto :goto_0

    .line 231
    :pswitch_5
    iget-object v1, p0, Lcom/poshmark/utils/sharing/ServerShareMessages;->data:Lcom/poshmark/utils/sharing/ShareMessagesContainer;

    if-eqz v1, :cond_0

    iget-object v1, p0, Lcom/poshmark/utils/sharing/ServerShareMessages;->data:Lcom/poshmark/utils/sharing/ShareMessagesContainer;

    iget-object v1, v1, Lcom/poshmark/utils/sharing/ShareMessagesContainer;->email:Lcom/poshmark/utils/sharing/share_states/Payload;

    if-eqz v1, :cond_0

    .line 232
    iget-object v1, p0, Lcom/poshmark/utils/sharing/ServerShareMessages;->data:Lcom/poshmark/utils/sharing/ShareMessagesContainer;

    iget-object v1, v1, Lcom/poshmark/utils/sharing/ShareMessagesContainer;->email:Lcom/poshmark/utils/sharing/share_states/Payload;

    iget-object v0, v1, Lcom/poshmark/utils/sharing/share_states/Payload;->url:Ljava/lang/String;

    goto :goto_0

    .line 236
    :pswitch_6
    iget-object v1, p0, Lcom/poshmark/utils/sharing/ServerShareMessages;->data:Lcom/poshmark/utils/sharing/ShareMessagesContainer;

    if-eqz v1, :cond_0

    iget-object v1, p0, Lcom/poshmark/utils/sharing/ServerShareMessages;->data:Lcom/poshmark/utils/sharing/ShareMessagesContainer;

    iget-object v1, v1, Lcom/poshmark/utils/sharing/ShareMessagesContainer;->sms:Lcom/poshmark/utils/sharing/share_states/Payload;

    if-eqz v1, :cond_0

    .line 237
    iget-object v1, p0, Lcom/poshmark/utils/sharing/ServerShareMessages;->data:Lcom/poshmark/utils/sharing/ShareMessagesContainer;

    iget-object v1, v1, Lcom/poshmark/utils/sharing/ShareMessagesContainer;->sms:Lcom/poshmark/utils/sharing/share_states/Payload;

    iget-object v0, v1, Lcom/poshmark/utils/sharing/share_states/Payload;->url:Ljava/lang/String;

    goto :goto_0

    .line 241
    :pswitch_7
    iget-object v1, p0, Lcom/poshmark/utils/sharing/ServerShareMessages;->data:Lcom/poshmark/utils/sharing/ShareMessagesContainer;

    if-eqz v1, :cond_0

    iget-object v1, p0, Lcom/poshmark/utils/sharing/ServerShareMessages;->data:Lcom/poshmark/utils/sharing/ShareMessagesContainer;

    iget-object v1, v1, Lcom/poshmark/utils/sharing/ShareMessagesContainer;->pnd:Lcom/poshmark/utils/sharing/share_states/Payload;

    if-eqz v1, :cond_0

    .line 242
    iget-object v1, p0, Lcom/poshmark/utils/sharing/ServerShareMessages;->data:Lcom/poshmark/utils/sharing/ShareMessagesContainer;

    iget-object v1, v1, Lcom/poshmark/utils/sharing/ShareMessagesContainer;->pnd:Lcom/poshmark/utils/sharing/share_states/Payload;

    iget-object v0, v1, Lcom/poshmark/utils/sharing/share_states/Payload;->url:Ljava/lang/String;

    goto/16 :goto_0

    .line 204
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
        :pswitch_2
        :pswitch_3
        :pswitch_4
        :pswitch_5
        :pswitch_6
        :pswitch_7
    .end packed-switch
.end method
