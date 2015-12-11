.class public Lcom/amazon/mcc/nps/Topic;
.super Ljava/lang/Object;
.source "Topic.java"


# instance fields
.field private final identifier:Ljava/lang/String;


# direct methods
.method public constructor <init>(Ljava/lang/String;)V
    .locals 0
    .param p1, "identifier"    # Ljava/lang/String;

    .prologue
    .line 56
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 57
    invoke-direct {p0, p1}, Lcom/amazon/mcc/nps/Topic;->validateIdentifier(Ljava/lang/String;)V

    .line 58
    iput-object p1, p0, Lcom/amazon/mcc/nps/Topic;->identifier:Ljava/lang/String;

    .line 59
    return-void
.end method

.method public static of(Ljava/lang/String;)Lcom/amazon/mcc/nps/Topic;
    .locals 1
    .param p0, "identifier"    # Ljava/lang/String;

    .prologue
    .line 43
    new-instance v0, Lcom/amazon/mcc/nps/Topic;

    invoke-direct {v0, p0}, Lcom/amazon/mcc/nps/Topic;-><init>(Ljava/lang/String;)V

    return-object v0
.end method

.method private validateIdentifier(Ljava/lang/String;)V
    .locals 2
    .param p1, "identifier"    # Ljava/lang/String;

    .prologue
    .line 62
    if-nez p1, :cond_0

    .line 63
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v1, "Topic identifier must not be null."

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 67
    :cond_0
    invoke-virtual {p1}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v0

    if-nez v0, :cond_1

    .line 68
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v1, "Topic identifier must not be empty or blank."

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 71
    :cond_1
    return-void
.end method


# virtual methods
.method public equals(Ljava/lang/Object;)Z
    .locals 5
    .param p1, "obj"    # Ljava/lang/Object;

    .prologue
    const/4 v1, 0x1

    const/4 v2, 0x0

    .line 84
    if-ne p0, p1, :cond_1

    .line 104
    :cond_0
    :goto_0
    return v1

    .line 88
    :cond_1
    if-nez p1, :cond_2

    move v1, v2

    .line 89
    goto :goto_0

    .line 92
    :cond_2
    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v3

    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v4

    if-eq v3, v4, :cond_3

    move v1, v2

    .line 93
    goto :goto_0

    :cond_3
    move-object v0, p1

    .line 96
    check-cast v0, Lcom/amazon/mcc/nps/Topic;

    .line 97
    .local v0, "other":Lcom/amazon/mcc/nps/Topic;
    iget-object v3, p0, Lcom/amazon/mcc/nps/Topic;->identifier:Ljava/lang/String;

    if-nez v3, :cond_4

    .line 98
    iget-object v3, v0, Lcom/amazon/mcc/nps/Topic;->identifier:Ljava/lang/String;

    if-eqz v3, :cond_0

    move v1, v2

    .line 99
    goto :goto_0

    .line 100
    :cond_4
    iget-object v3, p0, Lcom/amazon/mcc/nps/Topic;->identifier:Ljava/lang/String;

    iget-object v4, v0, Lcom/amazon/mcc/nps/Topic;->identifier:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_0

    move v1, v2

    .line 101
    goto :goto_0
.end method

.method public getIdentifier()Ljava/lang/String;
    .locals 1

    .prologue
    .line 113
    iget-object v0, p0, Lcom/amazon/mcc/nps/Topic;->identifier:Ljava/lang/String;

    return-object v0
.end method

.method public hashCode()I
    .locals 3

    .prologue
    .line 75
    const/16 v0, 0x1f

    .line 76
    .local v0, "prime":I
    const/4 v1, 0x1

    .line 77
    .local v1, "result":I
    iget-object v2, p0, Lcom/amazon/mcc/nps/Topic;->identifier:Ljava/lang/String;

    if-nez v2, :cond_0

    const/4 v2, 0x0

    :goto_0
    add-int/lit8 v1, v2, 0x1f

    .line 79
    return v1

    .line 77
    :cond_0
    iget-object v2, p0, Lcom/amazon/mcc/nps/Topic;->identifier:Ljava/lang/String;

    invoke-virtual {v2}, Ljava/lang/String;->hashCode()I

    move-result v2

    goto :goto_0
.end method
