.class public Lcom/amazon/retailsearch/log/AndroidLog;
.super Lcom/amazon/retailsearch/log/AbstractMessageRecorder;
.source "AndroidLog.java"


# direct methods
.method public constructor <init>(Lcom/amazon/retailsearch/log/AppLog;)V
    .locals 0
    .param p1, "appLog"    # Lcom/amazon/retailsearch/log/AppLog;

    .prologue
    .line 12
    invoke-direct {p0, p1}, Lcom/amazon/retailsearch/log/AbstractMessageRecorder;-><init>(Lcom/amazon/retailsearch/log/AppLog;)V

    .line 13
    return-void
.end method

.method private logMessage(Lcom/amazon/retailsearch/log/MessageLogger;ILjava/lang/String;)V
    .locals 1
    .param p1, "source"    # Lcom/amazon/retailsearch/log/MessageLogger;
    .param p2, "level"    # I
    .param p3, "message"    # Ljava/lang/String;

    .prologue
    .line 51
    packed-switch p2, :pswitch_data_0

    .line 66
    invoke-interface {p1}, Lcom/amazon/retailsearch/log/MessageLogger;->getTag()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0, p3}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    .line 69
    :goto_0
    return-void

    .line 54
    :pswitch_0
    invoke-interface {p1}, Lcom/amazon/retailsearch/log/MessageLogger;->getTag()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0, p3}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0

    .line 57
    :pswitch_1
    invoke-interface {p1}, Lcom/amazon/retailsearch/log/MessageLogger;->getTag()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0, p3}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0

    .line 60
    :pswitch_2
    invoke-interface {p1}, Lcom/amazon/retailsearch/log/MessageLogger;->getTag()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0, p3}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0

    .line 63
    :pswitch_3
    invoke-interface {p1}, Lcom/amazon/retailsearch/log/MessageLogger;->getTag()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0, p3}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0

    .line 51
    nop

    :pswitch_data_0
    .packed-switch 0x3
        :pswitch_3
        :pswitch_2
        :pswitch_1
        :pswitch_0
    .end packed-switch
.end method


# virtual methods
.method public log(Lcom/amazon/retailsearch/log/MessageLogger;ILjava/lang/String;Ljava/lang/Throwable;)V
    .locals 1
    .param p1, "source"    # Lcom/amazon/retailsearch/log/MessageLogger;
    .param p2, "level"    # I
    .param p3, "message"    # Ljava/lang/String;
    .param p4, "throwable"    # Ljava/lang/Throwable;

    .prologue
    .line 18
    invoke-virtual {p0}, Lcom/amazon/retailsearch/log/AndroidLog;->getAppLog()Lcom/amazon/retailsearch/log/AppLog;

    move-result-object v0

    invoke-virtual {v0, p2}, Lcom/amazon/retailsearch/log/AppLog;->enabled(I)Z

    move-result v0

    if-nez v0, :cond_0

    .line 47
    :goto_0
    return-void

    .line 23
    :cond_0
    if-nez p4, :cond_1

    .line 25
    invoke-direct {p0, p1, p2, p3}, Lcom/amazon/retailsearch/log/AndroidLog;->logMessage(Lcom/amazon/retailsearch/log/MessageLogger;ILjava/lang/String;)V

    goto :goto_0

    .line 29
    :cond_1
    packed-switch p2, :pswitch_data_0

    .line 44
    invoke-interface {p1}, Lcom/amazon/retailsearch/log/MessageLogger;->getTag()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0, p3, p4}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    goto :goto_0

    .line 32
    :pswitch_0
    invoke-interface {p1}, Lcom/amazon/retailsearch/log/MessageLogger;->getTag()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0, p3, p4}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    goto :goto_0

    .line 35
    :pswitch_1
    invoke-interface {p1}, Lcom/amazon/retailsearch/log/MessageLogger;->getTag()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0, p3, p4}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    goto :goto_0

    .line 38
    :pswitch_2
    invoke-interface {p1}, Lcom/amazon/retailsearch/log/MessageLogger;->getTag()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0, p3, p4}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    goto :goto_0

    .line 41
    :pswitch_3
    invoke-interface {p1}, Lcom/amazon/retailsearch/log/MessageLogger;->getTag()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0, p3, p4}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    goto :goto_0

    .line 29
    :pswitch_data_0
    .packed-switch 0x3
        :pswitch_3
        :pswitch_2
        :pswitch_1
        :pswitch_0
    .end packed-switch
.end method
