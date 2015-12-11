.class public Lorg/apache/log4j/helpers/AppenderAttachableImpl;
.super Ljava/lang/Object;
.source "AppenderAttachableImpl.java"

# interfaces
.implements Lorg/apache/log4j/spi/AppenderAttachable;


# instance fields
.field protected appenderList:Ljava/util/Vector;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 33
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public addAppender(Lorg/apache/log4j/Appender;)V
    .locals 2
    .param p1, "newAppender"    # Lorg/apache/log4j/Appender;

    .prologue
    .line 45
    if-nez p1, :cond_1

    .line 53
    :cond_0
    :goto_0
    return-void

    .line 48
    :cond_1
    iget-object v0, p0, Lorg/apache/log4j/helpers/AppenderAttachableImpl;->appenderList:Ljava/util/Vector;

    if-nez v0, :cond_2

    .line 49
    new-instance v0, Ljava/util/Vector;

    const/4 v1, 0x1

    invoke-direct {v0, v1}, Ljava/util/Vector;-><init>(I)V

    iput-object v0, p0, Lorg/apache/log4j/helpers/AppenderAttachableImpl;->appenderList:Ljava/util/Vector;

    .line 51
    :cond_2
    iget-object v0, p0, Lorg/apache/log4j/helpers/AppenderAttachableImpl;->appenderList:Ljava/util/Vector;

    invoke-virtual {v0, p1}, Ljava/util/Vector;->contains(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 52
    iget-object v0, p0, Lorg/apache/log4j/helpers/AppenderAttachableImpl;->appenderList:Ljava/util/Vector;

    invoke-virtual {v0, p1}, Ljava/util/Vector;->addElement(Ljava/lang/Object;)V

    goto :goto_0
.end method

.method public appendLoopOnAppenders(Lorg/apache/log4j/spi/LoggingEvent;)I
    .locals 4
    .param p1, "event"    # Lorg/apache/log4j/spi/LoggingEvent;

    .prologue
    .line 59
    const/4 v2, 0x0

    .line 62
    .local v2, "size":I
    iget-object v3, p0, Lorg/apache/log4j/helpers/AppenderAttachableImpl;->appenderList:Ljava/util/Vector;

    if-eqz v3, :cond_0

    .line 63
    iget-object v3, p0, Lorg/apache/log4j/helpers/AppenderAttachableImpl;->appenderList:Ljava/util/Vector;

    invoke-virtual {v3}, Ljava/util/Vector;->size()I

    move-result v2

    .line 64
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    if-ge v1, v2, :cond_0

    .line 65
    iget-object v3, p0, Lorg/apache/log4j/helpers/AppenderAttachableImpl;->appenderList:Ljava/util/Vector;

    invoke-virtual {v3, v1}, Ljava/util/Vector;->elementAt(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lorg/apache/log4j/Appender;

    .line 66
    .local v0, "appender":Lorg/apache/log4j/Appender;
    invoke-interface {v0, p1}, Lorg/apache/log4j/Appender;->doAppend(Lorg/apache/log4j/spi/LoggingEvent;)V

    .line 64
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 69
    .end local v0    # "appender":Lorg/apache/log4j/Appender;
    .end local v1    # "i":I
    :cond_0
    return v2
.end method

.method public getAllAppenders()Ljava/util/Enumeration;
    .locals 1

    .prologue
    .line 81
    iget-object v0, p0, Lorg/apache/log4j/helpers/AppenderAttachableImpl;->appenderList:Ljava/util/Vector;

    if-nez v0, :cond_0

    .line 82
    const/4 v0, 0x0

    .line 84
    :goto_0
    return-object v0

    :cond_0
    iget-object v0, p0, Lorg/apache/log4j/helpers/AppenderAttachableImpl;->appenderList:Ljava/util/Vector;

    invoke-virtual {v0}, Ljava/util/Vector;->elements()Ljava/util/Enumeration;

    move-result-object v0

    goto :goto_0
.end method

.method public removeAllAppenders()V
    .locals 4

    .prologue
    .line 137
    iget-object v3, p0, Lorg/apache/log4j/helpers/AppenderAttachableImpl;->appenderList:Ljava/util/Vector;

    if-eqz v3, :cond_1

    .line 138
    iget-object v3, p0, Lorg/apache/log4j/helpers/AppenderAttachableImpl;->appenderList:Ljava/util/Vector;

    invoke-virtual {v3}, Ljava/util/Vector;->size()I

    move-result v2

    .line 139
    .local v2, "len":I
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    if-ge v1, v2, :cond_0

    .line 140
    iget-object v3, p0, Lorg/apache/log4j/helpers/AppenderAttachableImpl;->appenderList:Ljava/util/Vector;

    invoke-virtual {v3, v1}, Ljava/util/Vector;->elementAt(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lorg/apache/log4j/Appender;

    .line 141
    .local v0, "a":Lorg/apache/log4j/Appender;
    invoke-interface {v0}, Lorg/apache/log4j/Appender;->close()V

    .line 139
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 143
    .end local v0    # "a":Lorg/apache/log4j/Appender;
    :cond_0
    iget-object v3, p0, Lorg/apache/log4j/helpers/AppenderAttachableImpl;->appenderList:Ljava/util/Vector;

    invoke-virtual {v3}, Ljava/util/Vector;->removeAllElements()V

    .line 144
    const/4 v3, 0x0

    iput-object v3, p0, Lorg/apache/log4j/helpers/AppenderAttachableImpl;->appenderList:Ljava/util/Vector;

    .line 146
    .end local v1    # "i":I
    .end local v2    # "len":I
    :cond_1
    return-void
.end method
