.class public final Lcom/xfinity/playerlib/model/MerlinId;
.super Ljava/lang/Object;
.source "MerlinId.java"

# interfaces
.implements Ljava/io/Serializable;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/xfinity/playerlib/model/MerlinId$Namespace;
    }
.end annotation


# instance fields
.field private final namespace:Lcom/xfinity/playerlib/model/MerlinId$Namespace;

.field private final simpleId:J


# direct methods
.method public constructor <init>(Lcom/xfinity/playerlib/model/MerlinId$Namespace;Ljava/lang/Long;)V
    .locals 2
    .param p1, "namespace"    # Lcom/xfinity/playerlib/model/MerlinId$Namespace;
    .param p2, "simpleId"    # Ljava/lang/Long;

    .prologue
    .line 35
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 36
    invoke-static {p1}, Lorg/apache/commons/lang3/Validate;->notNull(Ljava/lang/Object;)Ljava/lang/Object;

    .line 37
    iput-object p1, p0, Lcom/xfinity/playerlib/model/MerlinId;->namespace:Lcom/xfinity/playerlib/model/MerlinId$Namespace;

    .line 38
    invoke-virtual {p2}, Ljava/lang/Long;->longValue()J

    move-result-wide v0

    iput-wide v0, p0, Lcom/xfinity/playerlib/model/MerlinId;->simpleId:J

    .line 39
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;)V
    .locals 4
    .param p1, "namespacedId"    # Ljava/lang/String;

    .prologue
    .line 25
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 26
    invoke-static {p1}, Lorg/apache/commons/lang3/Validate;->notNull(Ljava/lang/Object;)Ljava/lang/Object;

    .line 27
    const-string v1, "-"

    invoke-static {p1, v1}, Lorg/apache/commons/lang3/StringUtils;->split(Ljava/lang/String;Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v0

    .line 28
    .local v0, "split":[Ljava/lang/String;
    array-length v1, v0

    const/4 v2, 0x2

    if-eq v1, v2, :cond_0

    .line 29
    new-instance v1, Ljava/lang/IllegalArgumentException;

    const-string v2, "ID should be in the form namespace-longID (f.e. TvSeries-12345)"

    invoke-direct {v1, v2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 31
    :cond_0
    const/4 v1, 0x0

    aget-object v1, v0, v1

    invoke-static {v1}, Lcom/xfinity/playerlib/model/MerlinId$Namespace;->valueOf(Ljava/lang/String;)Lcom/xfinity/playerlib/model/MerlinId$Namespace;

    move-result-object v1

    iput-object v1, p0, Lcom/xfinity/playerlib/model/MerlinId;->namespace:Lcom/xfinity/playerlib/model/MerlinId$Namespace;

    .line 32
    const/4 v1, 0x1

    aget-object v1, v0, v1

    invoke-static {v1}, Ljava/lang/Long;->parseLong(Ljava/lang/String;)J

    move-result-wide v2

    iput-wide v2, p0, Lcom/xfinity/playerlib/model/MerlinId;->simpleId:J

    .line 33
    return-void
.end method


# virtual methods
.method public equals(Ljava/lang/Object;)Z
    .locals 8
    .param p1, "o"    # Ljava/lang/Object;

    .prologue
    const/4 v1, 0x1

    const/4 v2, 0x0

    .line 59
    if-ne p0, p1, :cond_1

    .line 66
    :cond_0
    :goto_0
    return v1

    .line 62
    :cond_1
    if-eqz p1, :cond_2

    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v3

    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v4

    if-eq v3, v4, :cond_3

    :cond_2
    move v1, v2

    .line 63
    goto :goto_0

    :cond_3
    move-object v0, p1

    .line 65
    check-cast v0, Lcom/xfinity/playerlib/model/MerlinId;

    .line 66
    .local v0, "merlinId":Lcom/xfinity/playerlib/model/MerlinId;
    iget-wide v4, p0, Lcom/xfinity/playerlib/model/MerlinId;->simpleId:J

    iget-wide v6, v0, Lcom/xfinity/playerlib/model/MerlinId;->simpleId:J

    cmp-long v3, v4, v6

    if-nez v3, :cond_4

    iget-object v3, p0, Lcom/xfinity/playerlib/model/MerlinId;->namespace:Lcom/xfinity/playerlib/model/MerlinId$Namespace;

    iget-object v4, v0, Lcom/xfinity/playerlib/model/MerlinId;->namespace:Lcom/xfinity/playerlib/model/MerlinId$Namespace;

    if-eq v3, v4, :cond_0

    :cond_4
    move v1, v2

    goto :goto_0
.end method

.method public getAsLegacyBobid()Ljava/lang/String;
    .locals 1

    .prologue
    .line 54
    invoke-virtual {p0}, Lcom/xfinity/playerlib/model/MerlinId;->getNamespacedId()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getNamespace()Lcom/xfinity/playerlib/model/MerlinId$Namespace;
    .locals 1

    .prologue
    .line 46
    iget-object v0, p0, Lcom/xfinity/playerlib/model/MerlinId;->namespace:Lcom/xfinity/playerlib/model/MerlinId$Namespace;

    return-object v0
.end method

.method public getNamespacedId()Ljava/lang/String;
    .locals 4

    .prologue
    .line 50
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v1, p0, Lcom/xfinity/playerlib/model/MerlinId;->namespace:Lcom/xfinity/playerlib/model/MerlinId$Namespace;

    invoke-virtual {v1}, Lcom/xfinity/playerlib/model/MerlinId$Namespace;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "-"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-wide v2, p0, Lcom/xfinity/playerlib/model/MerlinId;->simpleId:J

    invoke-virtual {v0, v2, v3}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getSimpleId()Ljava/lang/Long;
    .locals 2

    .prologue
    .line 42
    iget-wide v0, p0, Lcom/xfinity/playerlib/model/MerlinId;->simpleId:J

    invoke-static {v0, v1}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v0

    return-object v0
.end method

.method public hashCode()I
    .locals 4

    .prologue
    .line 78
    iget-object v1, p0, Lcom/xfinity/playerlib/model/MerlinId;->namespace:Lcom/xfinity/playerlib/model/MerlinId$Namespace;

    invoke-virtual {v1}, Lcom/xfinity/playerlib/model/MerlinId$Namespace;->hashCode()I

    move-result v0

    .line 79
    .local v0, "result":I
    mul-int/lit8 v1, v0, 0x1f

    iget-wide v2, p0, Lcom/xfinity/playerlib/model/MerlinId;->simpleId:J

    long-to-int v2, v2

    add-int v0, v1, v2

    .line 80
    return v0
.end method

.method public toString()Ljava/lang/String;
    .locals 1
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonValue;
    .end annotation

    .prologue
    .line 73
    invoke-virtual {p0}, Lcom/xfinity/playerlib/model/MerlinId;->getNamespacedId()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
