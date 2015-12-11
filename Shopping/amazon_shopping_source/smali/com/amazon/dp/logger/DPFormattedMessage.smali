.class public Lcom/amazon/dp/logger/DPFormattedMessage;
.super Ljava/lang/Object;
.source "DPFormattedMessage.java"


# instance fields
.field private final mFormattedString:Ljava/lang/String;

.field private mThrowable:Ljava/lang/Throwable;


# direct methods
.method public varargs constructor <init>(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    .locals 1
    .param p1, "origin"    # Ljava/lang/String;
    .param p2, "message"    # Ljava/lang/String;
    .param p3, "keyValuePairs"    # [Ljava/lang/Object;

    .prologue
    .line 48
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 49
    invoke-static {p1, p2, p3}, Lcom/amazon/dp/logger/DPFormattedMessage;->toDPFormat(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/dp/logger/DPFormattedMessage;->mFormattedString:Ljava/lang/String;

    .line 50
    array-length v0, p3

    if-lez v0, :cond_0

    array-length v0, p3

    add-int/lit8 v0, v0, -0x1

    aget-object v0, p3, v0

    instance-of v0, v0, Ljava/lang/Throwable;

    if-eqz v0, :cond_0

    .line 51
    array-length v0, p3

    add-int/lit8 v0, v0, -0x1

    aget-object v0, p3, v0

    check-cast v0, Ljava/lang/Throwable;

    iput-object v0, p0, Lcom/amazon/dp/logger/DPFormattedMessage;->mThrowable:Ljava/lang/Throwable;

    .line 53
    :cond_0
    return-void
.end method

.method public static varargs toDPFormat(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    .locals 7
    .param p0, "origin"    # Ljava/lang/String;
    .param p1, "message"    # Ljava/lang/String;
    .param p2, "keyValuePairs"    # [Ljava/lang/Object;

    .prologue
    .line 94
    array-length v1, p2

    .line 95
    .local v1, "n":I
    if-nez p0, :cond_3

    const-string/jumbo v3, "<null>"

    .line 96
    .local v3, "sanitizedOrigin":Ljava/lang/String;
    :goto_0
    if-nez p1, :cond_4

    const-string/jumbo v2, "<null>"

    .line 98
    .local v2, "sanitizedMessage":Ljava/lang/String;
    :goto_1
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-virtual {v3}, Ljava/lang/String;->length()I

    move-result v5

    invoke-virtual {v2}, Ljava/lang/String;->length()I

    move-result v6

    add-int/2addr v5, v6

    mul-int/lit8 v6, v1, 0x28

    add-int/2addr v5, v6

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(I)V

    .line 99
    .local v4, "sb":Ljava/lang/StringBuilder;
    invoke-virtual {v4, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string/jumbo v6, " - "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string/jumbo v6, ";"

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 101
    if-lez v1, :cond_0

    add-int/lit8 v5, v1, -0x1

    aget-object v5, p2, v5

    instance-of v5, v5, Ljava/lang/Throwable;

    if-eqz v5, :cond_0

    .line 102
    add-int/lit8 v1, v1, -0x1

    .line 105
    :cond_0
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_2
    if-ge v0, v1, :cond_5

    .line 106
    if-lez v0, :cond_1

    .line 107
    const-string/jumbo v5, ","

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 110
    :cond_1
    const-string/jumbo v5, " "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    aget-object v6, p2, v0

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    .line 111
    add-int/lit8 v0, v0, 0x1

    .line 113
    if-ge v0, v1, :cond_2

    .line 114
    const-string/jumbo v5, ": "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    aget-object v6, p2, v0

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    .line 105
    :cond_2
    add-int/lit8 v0, v0, 0x1

    goto :goto_2

    .end local v0    # "i":I
    .end local v2    # "sanitizedMessage":Ljava/lang/String;
    .end local v3    # "sanitizedOrigin":Ljava/lang/String;
    .end local v4    # "sb":Ljava/lang/StringBuilder;
    :cond_3
    move-object v3, p0

    .line 95
    goto :goto_0

    .restart local v3    # "sanitizedOrigin":Ljava/lang/String;
    :cond_4
    move-object v2, p1

    .line 96
    goto :goto_1

    .line 118
    .restart local v0    # "i":I
    .restart local v2    # "sanitizedMessage":Ljava/lang/String;
    .restart local v4    # "sb":Ljava/lang/StringBuilder;
    :cond_5
    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    return-object v5
.end method


# virtual methods
.method public getThrowable()Ljava/lang/Throwable;
    .locals 1

    .prologue
    .line 59
    iget-object v0, p0, Lcom/amazon/dp/logger/DPFormattedMessage;->mThrowable:Ljava/lang/Throwable;

    return-object v0
.end method

.method public toString()Ljava/lang/String;
    .locals 1

    .prologue
    .line 75
    iget-object v0, p0, Lcom/amazon/dp/logger/DPFormattedMessage;->mFormattedString:Ljava/lang/String;

    return-object v0
.end method
