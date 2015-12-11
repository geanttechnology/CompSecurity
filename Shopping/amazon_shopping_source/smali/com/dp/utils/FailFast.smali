.class public final Lcom/dp/utils/FailFast;
.super Ljava/lang/Object;
.source "FailFast.java"


# static fields
.field private static final log:Lcom/amazon/dp/logger/DPLogger;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 20
    new-instance v0, Lcom/amazon/dp/logger/DPLogger;

    invoke-direct {v0}, Lcom/amazon/dp/logger/DPLogger;-><init>()V

    sput-object v0, Lcom/dp/utils/FailFast;->log:Lcom/amazon/dp/logger/DPLogger;

    return-void
.end method

.method private constructor <init>()V
    .locals 0

    .prologue
    .line 25
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 26
    return-void
.end method

.method private static buildFailFastMessage(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    .locals 3
    .param p0, "expected"    # Ljava/lang/String;
    .param p1, "actual"    # Ljava/lang/String;
    .param p2, "messages"    # [Ljava/lang/Object;

    .prologue
    .line 182
    new-instance v0, Ljava/lang/StringBuilder;

    const-string/jumbo v2, "FailFast: "

    invoke-direct {v0, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 183
    .local v0, "builder":Ljava/lang/StringBuilder;
    const-string/jumbo v2, "expected<"

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 184
    invoke-virtual {v0, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 185
    const-string/jumbo v2, "> actual<"

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 186
    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 187
    const-string/jumbo v2, "> "

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 189
    if-eqz p2, :cond_0

    .line 190
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    array-length v2, p2

    if-ge v1, v2, :cond_0

    .line 191
    aget-object v2, p2, v1

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    .line 190
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 195
    .end local v1    # "i":I
    :cond_0
    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    return-object v2
.end method

.method private static buildFailFastMessage([Ljava/lang/Object;)Ljava/lang/String;
    .locals 3
    .param p0, "messages"    # [Ljava/lang/Object;

    .prologue
    .line 199
    new-instance v0, Ljava/lang/StringBuilder;

    const-string/jumbo v2, "FailFast: "

    invoke-direct {v0, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 201
    .local v0, "builder":Ljava/lang/StringBuilder;
    if-eqz p0, :cond_0

    .line 202
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    array-length v2, p0

    if-ge v1, v2, :cond_0

    .line 203
    aget-object v2, p0, v1

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    .line 202
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 207
    .end local v1    # "i":I
    :cond_0
    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    return-object v2
.end method

.method public static varargs expectEquals(II[Ljava/lang/Object;)V
    .locals 0
    .param p0, "expected"    # I
    .param p1, "actual"    # I
    .param p2, "messages"    # [Ljava/lang/Object;

    .prologue
    .line 149
    invoke-static {p0, p1, p2}, Lcom/dp/utils/FailFast;->failFastInternal(II[Ljava/lang/Object;)V

    .line 150
    return-void
.end method

.method public static expectNotNull(Ljava/lang/Object;)V
    .locals 2
    .param p0, "object"    # Ljava/lang/Object;

    .prologue
    const/4 v1, 0x0

    .line 93
    if-eqz p0, :cond_0

    const/4 v0, 0x1

    :goto_0
    new-array v1, v1, [Ljava/lang/Object;

    invoke-static {v0, v1}, Lcom/dp/utils/FailFast;->failFastInternal(Z[Ljava/lang/Object;)V

    .line 94
    return-void

    :cond_0
    move v0, v1

    .line 93
    goto :goto_0
.end method

.method public static varargs expectTrue(Z[Ljava/lang/Object;)V
    .locals 0
    .param p0, "condition"    # Z
    .param p1, "messages"    # [Ljava/lang/Object;

    .prologue
    .line 45
    invoke-static {p0, p1}, Lcom/dp/utils/FailFast;->failFastInternal(Z[Ljava/lang/Object;)V

    .line 46
    return-void
.end method

.method private static varargs failFastInternal(II[Ljava/lang/Object;)V
    .locals 3
    .param p0, "expected"    # I
    .param p1, "actual"    # I
    .param p2, "messages"    # [Ljava/lang/Object;

    .prologue
    .line 164
    if-eq p0, p1, :cond_0

    .line 165
    invoke-static {p0}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v1

    invoke-static {p1}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2, p2}, Lcom/dp/utils/FailFast;->buildFailFastMessage(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    .line 166
    .local v0, "message":Ljava/lang/String;
    invoke-static {v0}, Lcom/dp/utils/FailFast;->logFailFastMessage(Ljava/lang/String;)V

    .line 167
    invoke-static {}, Lcom/dp/utils/FailFast;->logStackTrace()V

    .line 168
    new-instance v1, Lcom/dp/utils/FailFastException;

    invoke-direct {v1}, Lcom/dp/utils/FailFastException;-><init>()V

    throw v1

    .line 170
    .end local v0    # "message":Ljava/lang/String;
    :cond_0
    return-void
.end method

.method private static varargs failFastInternal(Z[Ljava/lang/Object;)V
    .locals 2
    .param p0, "condition"    # Z
    .param p1, "messages"    # [Ljava/lang/Object;

    .prologue
    .line 173
    if-nez p0, :cond_0

    .line 174
    invoke-static {p1}, Lcom/dp/utils/FailFast;->buildFailFastMessage([Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    .line 175
    .local v0, "message":Ljava/lang/String;
    invoke-static {v0}, Lcom/dp/utils/FailFast;->logFailFastMessage(Ljava/lang/String;)V

    .line 176
    invoke-static {}, Lcom/dp/utils/FailFast;->logStackTrace()V

    .line 177
    new-instance v1, Lcom/dp/utils/FailFastException;

    invoke-direct {v1}, Lcom/dp/utils/FailFastException;-><init>()V

    throw v1

    .line 179
    .end local v0    # "message":Ljava/lang/String;
    :cond_0
    return-void
.end method

.method private static logFailFastMessage(Ljava/lang/String;)V
    .locals 3
    .param p0, "message"    # Ljava/lang/String;

    .prologue
    .line 211
    sget-object v0, Lcom/dp/utils/FailFast;->log:Lcom/amazon/dp/logger/DPLogger;

    const-string/jumbo v1, ""

    const/4 v2, 0x0

    new-array v2, v2, [Ljava/lang/Object;

    invoke-virtual {v0, v1, p0, v2}, Lcom/amazon/dp/logger/DPLogger;->error(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 212
    return-void
.end method

.method private static logStackTrace()V
    .locals 7

    .prologue
    .line 215
    new-instance v3, Ljava/lang/Throwable;

    invoke-direct {v3}, Ljava/lang/Throwable;-><init>()V

    invoke-virtual {v3}, Ljava/lang/Throwable;->getStackTrace()[Ljava/lang/StackTraceElement;

    move-result-object v2

    .line 217
    .local v2, "stack":[Ljava/lang/StackTraceElement;
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    array-length v3, v2

    if-ge v1, v3, :cond_0

    .line 218
    new-instance v0, Ljava/lang/StringBuilder;

    const-string/jumbo v3, "\t> "

    invoke-direct {v0, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 219
    .local v0, "builder":Ljava/lang/StringBuilder;
    aget-object v3, v2, v1

    invoke-virtual {v3}, Ljava/lang/StackTraceElement;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 220
    sget-object v3, Lcom/dp/utils/FailFast;->log:Lcom/amazon/dp/logger/DPLogger;

    const-string/jumbo v4, ""

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    const/4 v6, 0x0

    new-array v6, v6, [Ljava/lang/Object;

    invoke-virtual {v3, v4, v5, v6}, Lcom/amazon/dp/logger/DPLogger;->error(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 217
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 222
    .end local v0    # "builder":Ljava/lang/StringBuilder;
    :cond_0
    return-void
.end method
