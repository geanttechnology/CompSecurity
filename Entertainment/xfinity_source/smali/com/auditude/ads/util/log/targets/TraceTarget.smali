.class public Lcom/auditude/ads/util/log/targets/TraceTarget;
.super Lcom/auditude/ads/util/log/targets/AbstractTarget;
.source "TraceTarget.java"


# instance fields
.field public fieldSeparator:Ljava/lang/String;

.field public includeCategory:Ljava/lang/Boolean;

.field public includeDate:Ljava/lang/Boolean;

.field public includeLevel:Ljava/lang/Boolean;

.field public includeTime:Ljava/lang/Boolean;


# direct methods
.method public constructor <init>(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;)V
    .locals 1
    .param p1, "includeTime"    # Ljava/lang/Boolean;
    .param p2, "includeDate"    # Ljava/lang/Boolean;
    .param p3, "includeCategory"    # Ljava/lang/Boolean;
    .param p4, "includeLevel"    # Ljava/lang/Boolean;

    .prologue
    .line 18
    invoke-direct {p0}, Lcom/auditude/ads/util/log/targets/AbstractTarget;-><init>()V

    .line 30
    const-string v0, " "

    iput-object v0, p0, Lcom/auditude/ads/util/log/targets/TraceTarget;->fieldSeparator:Ljava/lang/String;

    .line 21
    iput-object p1, p0, Lcom/auditude/ads/util/log/targets/TraceTarget;->includeTime:Ljava/lang/Boolean;

    .line 22
    iput-object p2, p0, Lcom/auditude/ads/util/log/targets/TraceTarget;->includeDate:Ljava/lang/Boolean;

    .line 23
    iput-object p3, p0, Lcom/auditude/ads/util/log/targets/TraceTarget;->includeCategory:Ljava/lang/Boolean;

    .line 24
    iput-object p4, p0, Lcom/auditude/ads/util/log/targets/TraceTarget;->includeLevel:Ljava/lang/Boolean;

    .line 25
    return-void
.end method

.method private padTime(ILjava/lang/Boolean;)Ljava/lang/String;
    .locals 2
    .param p1, "num"    # I
    .param p2, "millis"    # Ljava/lang/Boolean;

    .prologue
    .line 121
    invoke-virtual {p2}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v0

    if-eqz v0, :cond_2

    .line 123
    const/16 v0, 0xa

    if-ge p1, v0, :cond_0

    .line 125
    new-instance v0, Ljava/lang/StringBuilder;

    const-string v1, "00"

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-static {p1}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 138
    :goto_0
    return-object v0

    .line 127
    :cond_0
    const/16 v0, 0x64

    if-ge p1, v0, :cond_1

    .line 129
    new-instance v0, Ljava/lang/StringBuilder;

    const-string v1, "0"

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-static {p1}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    .line 133
    :cond_1
    invoke-static {p1}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    .line 138
    :cond_2
    const/16 v0, 0x9

    if-le p1, v0, :cond_3

    invoke-static {p1}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    :cond_3
    new-instance v0, Ljava/lang/StringBuilder;

    const-string v1, "0"

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-static {p1}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method


# virtual methods
.method public logEvent(Lcom/auditude/ads/util/log/LogEvent;)V
    .locals 10
    .param p1, "event"    # Lcom/auditude/ads/util/log/LogEvent;

    .prologue
    const/4 v9, 0x1

    const/4 v8, 0x0

    .line 64
    const-string v2, ""

    .line 65
    .local v2, "date":Ljava/lang/String;
    iget-object v5, p0, Lcom/auditude/ads/util/log/targets/TraceTarget;->includeDate:Ljava/lang/Boolean;

    invoke-virtual {v5}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v5

    if-nez v5, :cond_0

    iget-object v5, p0, Lcom/auditude/ads/util/log/targets/TraceTarget;->includeTime:Ljava/lang/Boolean;

    invoke-virtual {v5}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v5

    if-eqz v5, :cond_2

    .line 67
    :cond_0
    invoke-static {}, Ljava/util/Calendar;->getInstance()Ljava/util/Calendar;

    move-result-object v0

    .line 68
    .local v0, "cal":Ljava/util/Calendar;
    new-instance v5, Ljava/util/Date;

    invoke-direct {v5}, Ljava/util/Date;-><init>()V

    invoke-virtual {v0, v5}, Ljava/util/Calendar;->setTime(Ljava/util/Date;)V

    .line 70
    iget-object v5, p0, Lcom/auditude/ads/util/log/targets/TraceTarget;->includeDate:Ljava/lang/Boolean;

    invoke-virtual {v5}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v5

    if-eqz v5, :cond_1

    .line 72
    new-instance v5, Ljava/lang/StringBuilder;

    const/4 v6, 0x2

    invoke-virtual {v0, v6}, Ljava/util/Calendar;->get(I)I

    move-result v6

    add-int/lit8 v6, v6, 0x1

    invoke-static {v6}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v6

    invoke-static {v6}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v6

    invoke-direct {v5, v6}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v6, "/"

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    .line 73
    const/4 v6, 0x5

    invoke-virtual {v0, v6}, Ljava/util/Calendar;->get(I)I

    move-result v6

    invoke-static {v6}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v6, "/"

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    .line 74
    invoke-virtual {v0, v9}, Ljava/util/Calendar;->get(I)I

    move-result v6

    invoke-static {v6}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    iget-object v6, p0, Lcom/auditude/ads/util/log/targets/TraceTarget;->fieldSeparator:Ljava/lang/String;

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    .line 72
    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 76
    :cond_1
    iget-object v5, p0, Lcom/auditude/ads/util/log/targets/TraceTarget;->includeTime:Ljava/lang/Boolean;

    invoke-virtual {v5}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v5

    if-eqz v5, :cond_2

    .line 78
    new-instance v5, Ljava/lang/StringBuilder;

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v6

    invoke-direct {v5, v6}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const/16 v6, 0xb

    invoke-virtual {v0, v6}, Ljava/util/Calendar;->get(I)I

    move-result v6

    invoke-static {v8}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v7

    invoke-direct {p0, v6, v7}, Lcom/auditude/ads/util/log/targets/TraceTarget;->padTime(ILjava/lang/Boolean;)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v6, ":"

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    .line 79
    const/16 v6, 0xc

    invoke-virtual {v0, v6}, Ljava/util/Calendar;->get(I)I

    move-result v6

    invoke-static {v8}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v7

    invoke-direct {p0, v6, v7}, Lcom/auditude/ads/util/log/targets/TraceTarget;->padTime(ILjava/lang/Boolean;)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v6, ":"

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    .line 80
    const/16 v6, 0xd

    invoke-virtual {v0, v6}, Ljava/util/Calendar;->get(I)I

    move-result v6

    invoke-static {v8}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v7

    invoke-direct {p0, v6, v7}, Lcom/auditude/ads/util/log/targets/TraceTarget;->padTime(ILjava/lang/Boolean;)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v6, "."

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    .line 81
    const/16 v6, 0xe

    invoke-virtual {v0, v6}, Ljava/util/Calendar;->get(I)I

    move-result v6

    invoke-static {v9}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v7

    invoke-direct {p0, v6, v7}, Lcom/auditude/ads/util/log/targets/TraceTarget;->padTime(ILjava/lang/Boolean;)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    iget-object v6, p0, Lcom/auditude/ads/util/log/targets/TraceTarget;->fieldSeparator:Ljava/lang/String;

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    .line 78
    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 86
    .end local v0    # "cal":Ljava/util/Calendar;
    :cond_2
    invoke-virtual {p1}, Lcom/auditude/ads/util/log/LogEvent;->getOwner()Lcom/auditude/ads/util/event/IEventDispatcher;

    move-result-object v5

    check-cast v5, Lcom/auditude/ads/util/log/ILogger;

    invoke-interface {v5}, Lcom/auditude/ads/util/log/ILogger;->getCategory()Ljava/lang/String;

    move-result-object v1

    .line 87
    .local v1, "category":Ljava/lang/String;
    new-instance v5, Ljava/lang/StringBuilder;

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v6

    invoke-direct {v5, v6}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v6, p1, Lcom/auditude/ads/util/log/LogEvent;->data:Ljava/lang/Object;

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    .line 89
    .local v4, "message":Ljava/lang/String;
    iget-object v5, p1, Lcom/auditude/ads/util/log/LogEvent;->level:Lcom/auditude/ads/util/log/LogLevel;

    invoke-virtual {v5}, Lcom/auditude/ads/util/log/LogLevel;->getVerbosity()I

    move-result v3

    .line 90
    .local v3, "level":I
    sget-object v5, Lcom/auditude/ads/util/log/LogLevel;->ERROR:Lcom/auditude/ads/util/log/LogLevel;

    invoke-virtual {v5}, Lcom/auditude/ads/util/log/LogLevel;->getVerbosity()I

    move-result v5

    if-ne v3, v5, :cond_3

    .line 92
    invoke-static {v1, v4}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 114
    :goto_0
    return-void

    .line 94
    :cond_3
    sget-object v5, Lcom/auditude/ads/util/log/LogLevel;->WARN:Lcom/auditude/ads/util/log/LogLevel;

    invoke-virtual {v5}, Lcom/auditude/ads/util/log/LogLevel;->getVerbosity()I

    move-result v5

    if-ne v3, v5, :cond_4

    .line 96
    invoke-static {v1, v4}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0

    .line 98
    :cond_4
    sget-object v5, Lcom/auditude/ads/util/log/LogLevel;->INFO:Lcom/auditude/ads/util/log/LogLevel;

    invoke-virtual {v5}, Lcom/auditude/ads/util/log/LogLevel;->getVerbosity()I

    move-result v5

    if-ne v3, v5, :cond_5

    .line 100
    invoke-static {v1, v4}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0

    .line 102
    :cond_5
    sget-object v5, Lcom/auditude/ads/util/log/LogLevel;->DEBUG:Lcom/auditude/ads/util/log/LogLevel;

    invoke-virtual {v5}, Lcom/auditude/ads/util/log/LogLevel;->getVerbosity()I

    move-result v5

    if-ne v3, v5, :cond_6

    .line 104
    invoke-static {v1, v4}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0

    .line 106
    :cond_6
    sget-object v5, Lcom/auditude/ads/util/log/LogLevel;->FATAL:Lcom/auditude/ads/util/log/LogLevel;

    invoke-virtual {v5}, Lcom/auditude/ads/util/log/LogLevel;->getVerbosity()I

    move-result v5

    if-ne v3, v5, :cond_7

    .line 108
    invoke-static {v1, v4}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0

    .line 112
    :cond_7
    invoke-static {v1, v4}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0
.end method
