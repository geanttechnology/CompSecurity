.class public Lcom/amazon/dp/logger/DPLogger;
.super Ljava/lang/Object;
.source "DPLogger.java"


# static fields
.field private static final BUILD_TYPE:Ljava/lang/String;


# instance fields
.field protected final mName:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 63
    sget-object v0, Landroid/os/Build;->TYPE:Ljava/lang/String;

    sput-object v0, Lcom/amazon/dp/logger/DPLogger;->BUILD_TYPE:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 2

    .prologue
    .line 74
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 75
    new-instance v0, Ljava/lang/Throwable;

    invoke-direct {v0}, Ljava/lang/Throwable;-><init>()V

    invoke-virtual {v0}, Ljava/lang/Throwable;->getStackTrace()[Ljava/lang/StackTraceElement;

    move-result-object v0

    const/4 v1, 0x1

    aget-object v0, v0, v1

    invoke-virtual {v0}, Ljava/lang/StackTraceElement;->getClassName()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/amazon/dp/logger/DPLogger;->removePackageName(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-direct {p0, v0}, Lcom/amazon/dp/logger/DPLogger;->ensureSafeName(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/dp/logger/DPLogger;->mName:Ljava/lang/String;

    .line 77
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;)V
    .locals 1
    .param p1, "name"    # Ljava/lang/String;

    .prologue
    .line 91
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 92
    invoke-direct {p0, p1}, Lcom/amazon/dp/logger/DPLogger;->ensureSafeName(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/dp/logger/DPLogger;->mName:Ljava/lang/String;

    .line 93
    return-void
.end method

.method private ensureSafeName(Ljava/lang/String;)Ljava/lang/String;
    .locals 7
    .param p1, "name"    # Ljava/lang/String;

    .prologue
    const/16 v2, 0x17

    const/4 v6, 0x0

    .line 332
    if-nez p1, :cond_0

    .line 333
    const-string/jumbo v1, "DPLogger"

    const-string/jumbo v2, "Got a null DPLogger name; using an empty string instead"

    invoke-static {v1, v2}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    .line 334
    const-string/jumbo v0, ""

    .line 343
    :goto_0
    return-object v0

    .line 335
    :cond_0
    invoke-virtual {p1}, Ljava/lang/String;->length()I

    move-result v1

    if-le v1, v2, :cond_1

    .line 336
    invoke-virtual {p1, v6, v2}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v0

    .line 337
    .local v0, "truncatedName":Ljava/lang/String;
    const-string/jumbo v1, "DPLogger"

    const-string/jumbo v2, "DPLogger"

    const-string/jumbo v3, "Name was too long. Truncating"

    const/4 v4, 0x4

    new-array v4, v4, [Ljava/lang/Object;

    const-string/jumbo v5, "original name"

    aput-object v5, v4, v6

    const/4 v5, 0x1

    aput-object p1, v4, v5

    const/4 v5, 0x2

    const-string/jumbo v6, "truncated name"

    aput-object v6, v4, v5

    const/4 v5, 0x3

    aput-object v0, v4, v5

    invoke-static {v2, v3, v4}, Lcom/amazon/dp/logger/DPFormattedMessage;->toDPFormat(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0

    .end local v0    # "truncatedName":Ljava/lang/String;
    :cond_1
    move-object v0, p1

    .line 343
    goto :goto_0
.end method

.method private static varargs extractThrowable([Ljava/lang/Object;)Ljava/lang/Throwable;
    .locals 3
    .param p0, "keyValuePairs"    # [Ljava/lang/Object;

    .prologue
    const/4 v1, 0x0

    .line 348
    if-eqz p0, :cond_0

    array-length v2, p0

    if-nez v2, :cond_1

    :cond_0
    move-object v0, v1

    .line 352
    :goto_0
    return-object v0

    .line 351
    :cond_1
    array-length v2, p0

    add-int/lit8 v2, v2, -0x1

    aget-object v0, p0, v2

    .line 352
    .local v0, "last":Ljava/lang/Object;
    instance-of v2, v0, Ljava/lang/Throwable;

    if-eqz v2, :cond_2

    check-cast v0, Ljava/lang/Throwable;

    goto :goto_0

    :cond_2
    move-object v0, v1

    goto :goto_0
.end method

.method private static removePackageName(Ljava/lang/String;)Ljava/lang/String;
    .locals 2
    .param p0, "className"    # Ljava/lang/String;

    .prologue
    .line 320
    const/16 v1, 0x2e

    invoke-virtual {p0, v1}, Ljava/lang/String;->lastIndexOf(I)I

    move-result v0

    .line 321
    .local v0, "lastIndex":I
    const/4 v1, -0x1

    if-eq v0, v1, :cond_0

    invoke-virtual {p0}, Ljava/lang/String;->length()I

    move-result v1

    add-int/lit8 v1, v1, -0x1

    if-gt v0, v1, :cond_0

    add-int/lit8 v1, v0, 0x1

    invoke-virtual {p0, v1}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object p0

    .end local p0    # "className":Ljava/lang/String;
    :cond_0
    return-object p0
.end method


# virtual methods
.method public varargs debug(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    .locals 3
    .param p1, "name"    # Ljava/lang/String;
    .param p2, "text"    # Ljava/lang/String;
    .param p3, "keyValuePairs"    # [Ljava/lang/Object;

    .prologue
    .line 254
    invoke-virtual {p0}, Lcom/amazon/dp/logger/DPLogger;->isDebugEnabled()Z

    move-result v2

    if-eqz v2, :cond_0

    .line 255
    invoke-static {p1, p2, p3}, Lcom/amazon/dp/logger/DPFormattedMessage;->toDPFormat(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    .line 256
    .local v0, "formattedMessage":Ljava/lang/String;
    invoke-static {p3}, Lcom/amazon/dp/logger/DPLogger;->extractThrowable([Ljava/lang/Object;)Ljava/lang/Throwable;

    move-result-object v1

    .line 257
    .local v1, "throwable":Ljava/lang/Throwable;
    if-nez v1, :cond_1

    .line 258
    iget-object v2, p0, Lcom/amazon/dp/logger/DPLogger;->mName:Ljava/lang/String;

    invoke-static {v2, v0}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 263
    .end local v0    # "formattedMessage":Ljava/lang/String;
    .end local v1    # "throwable":Ljava/lang/Throwable;
    :cond_0
    :goto_0
    return-void

    .line 260
    .restart local v0    # "formattedMessage":Ljava/lang/String;
    .restart local v1    # "throwable":Ljava/lang/Throwable;
    :cond_1
    iget-object v2, p0, Lcom/amazon/dp/logger/DPLogger;->mName:Ljava/lang/String;

    invoke-static {v2, v0, v1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    goto :goto_0
.end method

.method public error(Lcom/amazon/dp/logger/DPFormattedMessage;)V
    .locals 3
    .param p1, "message"    # Lcom/amazon/dp/logger/DPFormattedMessage;

    .prologue
    .line 200
    invoke-virtual {p0}, Lcom/amazon/dp/logger/DPLogger;->isErrorEnabled()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 201
    invoke-virtual {p1}, Lcom/amazon/dp/logger/DPFormattedMessage;->getThrowable()Ljava/lang/Throwable;

    move-result-object v0

    if-nez v0, :cond_1

    .line 202
    iget-object v0, p0, Lcom/amazon/dp/logger/DPLogger;->mName:Ljava/lang/String;

    invoke-virtual {p1}, Lcom/amazon/dp/logger/DPFormattedMessage;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 207
    :cond_0
    :goto_0
    return-void

    .line 204
    :cond_1
    iget-object v0, p0, Lcom/amazon/dp/logger/DPLogger;->mName:Ljava/lang/String;

    invoke-virtual {p1}, Lcom/amazon/dp/logger/DPFormattedMessage;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p1}, Lcom/amazon/dp/logger/DPFormattedMessage;->getThrowable()Ljava/lang/Throwable;

    move-result-object v2

    invoke-static {v0, v1, v2}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    goto :goto_0
.end method

.method public varargs error(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    .locals 3
    .param p1, "name"    # Ljava/lang/String;
    .param p2, "text"    # Ljava/lang/String;
    .param p3, "keyValuePairs"    # [Ljava/lang/Object;

    .prologue
    .line 188
    invoke-virtual {p0}, Lcom/amazon/dp/logger/DPLogger;->isErrorEnabled()Z

    move-result v2

    if-eqz v2, :cond_0

    .line 189
    invoke-static {p1, p2, p3}, Lcom/amazon/dp/logger/DPFormattedMessage;->toDPFormat(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    .line 190
    .local v0, "formattedMessage":Ljava/lang/String;
    invoke-static {p3}, Lcom/amazon/dp/logger/DPLogger;->extractThrowable([Ljava/lang/Object;)Ljava/lang/Throwable;

    move-result-object v1

    .line 191
    .local v1, "throwable":Ljava/lang/Throwable;
    if-nez v1, :cond_1

    .line 192
    iget-object v2, p0, Lcom/amazon/dp/logger/DPLogger;->mName:Ljava/lang/String;

    invoke-static {v2, v0}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 197
    .end local v0    # "formattedMessage":Ljava/lang/String;
    .end local v1    # "throwable":Ljava/lang/Throwable;
    :cond_0
    :goto_0
    return-void

    .line 194
    .restart local v0    # "formattedMessage":Ljava/lang/String;
    .restart local v1    # "throwable":Ljava/lang/Throwable;
    :cond_1
    iget-object v2, p0, Lcom/amazon/dp/logger/DPLogger;->mName:Ljava/lang/String;

    invoke-static {v2, v0, v1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    goto :goto_0
.end method

.method public varargs info(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    .locals 3
    .param p1, "name"    # Ljava/lang/String;
    .param p2, "text"    # Ljava/lang/String;
    .param p3, "keyValuePairs"    # [Ljava/lang/Object;

    .prologue
    .line 232
    invoke-virtual {p0}, Lcom/amazon/dp/logger/DPLogger;->isInfoEnabled()Z

    move-result v2

    if-eqz v2, :cond_0

    .line 233
    invoke-static {p1, p2, p3}, Lcom/amazon/dp/logger/DPFormattedMessage;->toDPFormat(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    .line 234
    .local v0, "formattedMessage":Ljava/lang/String;
    invoke-static {p3}, Lcom/amazon/dp/logger/DPLogger;->extractThrowable([Ljava/lang/Object;)Ljava/lang/Throwable;

    move-result-object v1

    .line 235
    .local v1, "throwable":Ljava/lang/Throwable;
    if-nez v1, :cond_1

    .line 236
    iget-object v2, p0, Lcom/amazon/dp/logger/DPLogger;->mName:Ljava/lang/String;

    invoke-static {v2, v0}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 241
    .end local v0    # "formattedMessage":Ljava/lang/String;
    .end local v1    # "throwable":Ljava/lang/Throwable;
    :cond_0
    :goto_0
    return-void

    .line 238
    .restart local v0    # "formattedMessage":Ljava/lang/String;
    .restart local v1    # "throwable":Ljava/lang/Throwable;
    :cond_1
    iget-object v2, p0, Lcom/amazon/dp/logger/DPLogger;->mName:Ljava/lang/String;

    invoke-static {v2, v0, v1}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    goto :goto_0
.end method

.method public isDebugEnabled()Z
    .locals 2

    .prologue
    .line 112
    iget-object v0, p0, Lcom/amazon/dp/logger/DPLogger;->mName:Ljava/lang/String;

    const/4 v1, 0x3

    invoke-static {v0, v1}, Landroid/util/Log;->isLoggable(Ljava/lang/String;I)Z

    move-result v0

    if-nez v0, :cond_0

    const-string/jumbo v0, "eng"

    sget-object v1, Lcom/amazon/dp/logger/DPLogger;->BUILD_TYPE:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    const/4 v0, 0x0

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x1

    goto :goto_0
.end method

.method public isErrorEnabled()Z
    .locals 2

    .prologue
    .line 145
    iget-object v0, p0, Lcom/amazon/dp/logger/DPLogger;->mName:Ljava/lang/String;

    const/4 v1, 0x6

    invoke-static {v0, v1}, Landroid/util/Log;->isLoggable(Ljava/lang/String;I)Z

    move-result v0

    if-nez v0, :cond_0

    const-string/jumbo v0, "eng"

    sget-object v1, Lcom/amazon/dp/logger/DPLogger;->BUILD_TYPE:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    const/4 v0, 0x0

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x1

    goto :goto_0
.end method

.method public isInfoEnabled()Z
    .locals 2

    .prologue
    .line 120
    iget-object v0, p0, Lcom/amazon/dp/logger/DPLogger;->mName:Ljava/lang/String;

    const/4 v1, 0x4

    invoke-static {v0, v1}, Landroid/util/Log;->isLoggable(Ljava/lang/String;I)Z

    move-result v0

    if-nez v0, :cond_0

    const-string/jumbo v0, "eng"

    sget-object v1, Lcom/amazon/dp/logger/DPLogger;->BUILD_TYPE:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    const/4 v0, 0x0

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x1

    goto :goto_0
.end method

.method public isVerboseEnabled()Z
    .locals 2

    .prologue
    .line 162
    iget-object v0, p0, Lcom/amazon/dp/logger/DPLogger;->mName:Ljava/lang/String;

    const/4 v1, 0x2

    invoke-static {v0, v1}, Landroid/util/Log;->isLoggable(Ljava/lang/String;I)Z

    move-result v0

    if-nez v0, :cond_0

    const-string/jumbo v0, "eng"

    sget-object v1, Lcom/amazon/dp/logger/DPLogger;->BUILD_TYPE:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    const/4 v0, 0x0

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x1

    goto :goto_0
.end method

.method public isWarnEnabled()Z
    .locals 2

    .prologue
    .line 137
    iget-object v0, p0, Lcom/amazon/dp/logger/DPLogger;->mName:Ljava/lang/String;

    const/4 v1, 0x5

    invoke-static {v0, v1}, Landroid/util/Log;->isLoggable(Ljava/lang/String;I)Z

    move-result v0

    if-nez v0, :cond_0

    const-string/jumbo v0, "eng"

    sget-object v1, Lcom/amazon/dp/logger/DPLogger;->BUILD_TYPE:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    const/4 v0, 0x0

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x1

    goto :goto_0
.end method

.method public varargs verbose(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    .locals 3
    .param p1, "name"    # Ljava/lang/String;
    .param p2, "text"    # Ljava/lang/String;
    .param p3, "keyValuePairs"    # [Ljava/lang/Object;

    .prologue
    .line 298
    invoke-virtual {p0}, Lcom/amazon/dp/logger/DPLogger;->isVerboseEnabled()Z

    move-result v2

    if-eqz v2, :cond_0

    .line 299
    invoke-static {p1, p2, p3}, Lcom/amazon/dp/logger/DPFormattedMessage;->toDPFormat(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    .line 300
    .local v0, "formattedMessage":Ljava/lang/String;
    invoke-static {p3}, Lcom/amazon/dp/logger/DPLogger;->extractThrowable([Ljava/lang/Object;)Ljava/lang/Throwable;

    move-result-object v1

    .line 301
    .local v1, "throwable":Ljava/lang/Throwable;
    if-nez v1, :cond_1

    .line 302
    iget-object v2, p0, Lcom/amazon/dp/logger/DPLogger;->mName:Ljava/lang/String;

    invoke-static {v2, v0}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    .line 307
    .end local v0    # "formattedMessage":Ljava/lang/String;
    .end local v1    # "throwable":Ljava/lang/Throwable;
    :cond_0
    :goto_0
    return-void

    .line 304
    .restart local v0    # "formattedMessage":Ljava/lang/String;
    .restart local v1    # "throwable":Ljava/lang/Throwable;
    :cond_1
    iget-object v2, p0, Lcom/amazon/dp/logger/DPLogger;->mName:Ljava/lang/String;

    invoke-static {v2, v0, v1}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    goto :goto_0
.end method

.method public varargs warn(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    .locals 3
    .param p1, "name"    # Ljava/lang/String;
    .param p2, "text"    # Ljava/lang/String;
    .param p3, "keyValuePairs"    # [Ljava/lang/Object;

    .prologue
    .line 210
    invoke-virtual {p0}, Lcom/amazon/dp/logger/DPLogger;->isWarnEnabled()Z

    move-result v2

    if-eqz v2, :cond_0

    .line 211
    invoke-static {p1, p2, p3}, Lcom/amazon/dp/logger/DPFormattedMessage;->toDPFormat(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    .line 212
    .local v0, "formattedMessage":Ljava/lang/String;
    invoke-static {p3}, Lcom/amazon/dp/logger/DPLogger;->extractThrowable([Ljava/lang/Object;)Ljava/lang/Throwable;

    move-result-object v1

    .line 213
    .local v1, "throwable":Ljava/lang/Throwable;
    if-nez v1, :cond_1

    .line 214
    iget-object v2, p0, Lcom/amazon/dp/logger/DPLogger;->mName:Ljava/lang/String;

    invoke-static {v2, v0}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    .line 219
    .end local v0    # "formattedMessage":Ljava/lang/String;
    .end local v1    # "throwable":Ljava/lang/Throwable;
    :cond_0
    :goto_0
    return-void

    .line 216
    .restart local v0    # "formattedMessage":Ljava/lang/String;
    .restart local v1    # "throwable":Ljava/lang/Throwable;
    :cond_1
    iget-object v2, p0, Lcom/amazon/dp/logger/DPLogger;->mName:Ljava/lang/String;

    invoke-static {v2, v0, v1}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    goto :goto_0
.end method
