.class public Lcom/amazon/identity/auth/device/storage/AccountInfo;
.super Ljava/lang/Object;
.source "AccountInfo.java"

# interfaces
.implements Lcom/amazon/identity/auth/device/utils/PublicCloneable;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lcom/amazon/identity/auth/device/utils/PublicCloneable",
        "<",
        "Lcom/amazon/identity/auth/device/storage/AccountInfo;",
        ">;"
    }
.end annotation


# instance fields
.field public final directedId:Ljava/lang/String;

.field public final displayName:Ljava/lang/String;

.field public final tokens:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Lcom/amazon/identity/auth/device/storage/DatabaseValue",
            "<",
            "Ljava/lang/String;",
            ">;>;"
        }
    .end annotation
.end field

.field public final userdata:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Lcom/amazon/identity/auth/device/storage/DatabaseValue",
            "<",
            "Ljava/lang/String;",
            ">;>;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;)V
    .locals 1
    .param p1, "givenDirectedId"    # Ljava/lang/String;
    .param p2, "givenDisplayName"    # Ljava/lang/String;

    .prologue
    .line 22
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    invoke-direct {p0, p1, p2, v0}, Lcom/amazon/identity/auth/device/storage/AccountInfo;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V

    .line 23
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V
    .locals 1
    .param p1, "givenDirectedId"    # Ljava/lang/String;
    .param p2, "givenDisplayName"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Lcom/amazon/identity/auth/device/storage/DatabaseValue",
            "<",
            "Ljava/lang/String;",
            ">;>;)V"
        }
    .end annotation

    .prologue
    .line 29
    .local p3, "givenUserdata":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Lcom/amazon/identity/auth/device/storage/DatabaseValue<Ljava/lang/String;>;>;"
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    invoke-direct {p0, p1, p2, p3, v0}, Lcom/amazon/identity/auth/device/storage/AccountInfo;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;)V

    .line 30
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;)V
    .locals 0
    .param p1, "givenDirectedId"    # Ljava/lang/String;
    .param p2, "givenDisplayName"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Lcom/amazon/identity/auth/device/storage/DatabaseValue",
            "<",
            "Ljava/lang/String;",
            ">;>;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Lcom/amazon/identity/auth/device/storage/DatabaseValue",
            "<",
            "Ljava/lang/String;",
            ">;>;)V"
        }
    .end annotation

    .prologue
    .line 36
    .local p3, "givenUserdata":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Lcom/amazon/identity/auth/device/storage/DatabaseValue<Ljava/lang/String;>;>;"
    .local p4, "givenTokens":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Lcom/amazon/identity/auth/device/storage/DatabaseValue<Ljava/lang/String;>;>;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 37
    iput-object p1, p0, Lcom/amazon/identity/auth/device/storage/AccountInfo;->directedId:Ljava/lang/String;

    .line 38
    iput-object p2, p0, Lcom/amazon/identity/auth/device/storage/AccountInfo;->displayName:Ljava/lang/String;

    .line 40
    iput-object p3, p0, Lcom/amazon/identity/auth/device/storage/AccountInfo;->userdata:Ljava/util/Map;

    .line 42
    iput-object p4, p0, Lcom/amazon/identity/auth/device/storage/AccountInfo;->tokens:Ljava/util/Map;

    .line 43
    return-void
.end method


# virtual methods
.method public cloneObject()Lcom/amazon/identity/auth/device/storage/AccountInfo;
    .locals 5

    .prologue
    .line 88
    new-instance v0, Lcom/amazon/identity/auth/device/storage/AccountInfo;

    iget-object v1, p0, Lcom/amazon/identity/auth/device/storage/AccountInfo;->directedId:Ljava/lang/String;

    iget-object v2, p0, Lcom/amazon/identity/auth/device/storage/AccountInfo;->displayName:Ljava/lang/String;

    iget-object v3, p0, Lcom/amazon/identity/auth/device/storage/AccountInfo;->userdata:Ljava/util/Map;

    invoke-static {v3}, Lcom/amazon/identity/auth/device/utils/GenericUtils;->cloneMap(Ljava/util/Map;)Ljava/util/Map;

    move-result-object v3

    iget-object v4, p0, Lcom/amazon/identity/auth/device/storage/AccountInfo;->tokens:Ljava/util/Map;

    invoke-static {v4}, Lcom/amazon/identity/auth/device/utils/GenericUtils;->cloneMap(Ljava/util/Map;)Ljava/util/Map;

    move-result-object v4

    invoke-direct {v0, v1, v2, v3, v4}, Lcom/amazon/identity/auth/device/storage/AccountInfo;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;)V

    return-object v0
.end method

.method public bridge synthetic cloneObject()Lcom/amazon/identity/auth/device/utils/PublicCloneable;
    .locals 1

    .prologue
    .line 12
    invoke-virtual {p0}, Lcom/amazon/identity/auth/device/storage/AccountInfo;->cloneObject()Lcom/amazon/identity/auth/device/storage/AccountInfo;

    move-result-object v0

    return-object v0
.end method

.method public equals(Ljava/lang/Object;)Z
    .locals 5
    .param p1, "obj"    # Ljava/lang/Object;

    .prologue
    const/4 v1, 0x1

    const/4 v2, 0x0

    .line 60
    if-ne p0, p1, :cond_1

    .line 71
    :cond_0
    :goto_0
    return v1

    .line 64
    :cond_1
    if-eqz p1, :cond_2

    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v3

    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v4

    if-eq v3, v4, :cond_3

    :cond_2
    move v1, v2

    .line 66
    goto :goto_0

    :cond_3
    move-object v0, p1

    .line 69
    check-cast v0, Lcom/amazon/identity/auth/device/storage/AccountInfo;

    .line 71
    .local v0, "other":Lcom/amazon/identity/auth/device/storage/AccountInfo;
    iget-object v3, p0, Lcom/amazon/identity/auth/device/storage/AccountInfo;->directedId:Ljava/lang/String;

    iget-object v4, v0, Lcom/amazon/identity/auth/device/storage/AccountInfo;->directedId:Ljava/lang/String;

    invoke-static {v3, v4}, Landroid/text/TextUtils;->equals(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z

    move-result v3

    if-eqz v3, :cond_4

    iget-object v3, p0, Lcom/amazon/identity/auth/device/storage/AccountInfo;->displayName:Ljava/lang/String;

    iget-object v4, v0, Lcom/amazon/identity/auth/device/storage/AccountInfo;->displayName:Ljava/lang/String;

    invoke-static {v3, v4}, Landroid/text/TextUtils;->equals(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z

    move-result v3

    if-eqz v3, :cond_4

    iget-object v3, p0, Lcom/amazon/identity/auth/device/storage/AccountInfo;->userdata:Ljava/util/Map;

    iget-object v4, v0, Lcom/amazon/identity/auth/device/storage/AccountInfo;->userdata:Ljava/util/Map;

    invoke-static {v3, v4}, Lcom/amazon/identity/auth/device/utils/GenericUtils;->equals(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_4

    iget-object v3, p0, Lcom/amazon/identity/auth/device/storage/AccountInfo;->tokens:Ljava/util/Map;

    iget-object v4, v0, Lcom/amazon/identity/auth/device/storage/AccountInfo;->tokens:Ljava/util/Map;

    invoke-static {v3, v4}, Lcom/amazon/identity/auth/device/utils/GenericUtils;->equals(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_0

    :cond_4
    move v1, v2

    goto :goto_0
.end method

.method public hashCode()I
    .locals 4

    .prologue
    const/4 v2, 0x0

    .line 48
    iget-object v1, p0, Lcom/amazon/identity/auth/device/storage/AccountInfo;->directedId:Ljava/lang/String;

    if-nez v1, :cond_0

    move v1, v2

    :goto_0
    add-int/lit8 v0, v1, 0x1f

    .line 51
    .local v0, "result":I
    mul-int/lit8 v3, v0, 0x1f

    iget-object v1, p0, Lcom/amazon/identity/auth/device/storage/AccountInfo;->displayName:Ljava/lang/String;

    if-nez v1, :cond_1

    move v1, v2

    :goto_1
    add-int v0, v3, v1

    .line 52
    mul-int/lit8 v3, v0, 0x1f

    iget-object v1, p0, Lcom/amazon/identity/auth/device/storage/AccountInfo;->tokens:Ljava/util/Map;

    if-nez v1, :cond_2

    move v1, v2

    :goto_2
    add-int v0, v3, v1

    .line 53
    mul-int/lit8 v1, v0, 0x1f

    iget-object v3, p0, Lcom/amazon/identity/auth/device/storage/AccountInfo;->userdata:Ljava/util/Map;

    if-nez v3, :cond_3

    :goto_3
    add-int/2addr v1, v2

    .line 54
    return v1

    .line 48
    .end local v0    # "result":I
    :cond_0
    iget-object v1, p0, Lcom/amazon/identity/auth/device/storage/AccountInfo;->directedId:Ljava/lang/String;

    invoke-virtual {v1}, Ljava/lang/String;->hashCode()I

    move-result v1

    goto :goto_0

    .line 51
    .restart local v0    # "result":I
    :cond_1
    iget-object v1, p0, Lcom/amazon/identity/auth/device/storage/AccountInfo;->displayName:Ljava/lang/String;

    invoke-virtual {v1}, Ljava/lang/String;->hashCode()I

    move-result v1

    goto :goto_1

    .line 52
    :cond_2
    iget-object v1, p0, Lcom/amazon/identity/auth/device/storage/AccountInfo;->tokens:Ljava/util/Map;

    invoke-interface {v1}, Ljava/util/Map;->hashCode()I

    move-result v1

    goto :goto_2

    .line 53
    :cond_3
    iget-object v2, p0, Lcom/amazon/identity/auth/device/storage/AccountInfo;->userdata:Ljava/util/Map;

    invoke-interface {v2}, Ljava/util/Map;->hashCode()I

    move-result v2

    goto :goto_3
.end method

.method public toString()Ljava/lang/String;
    .locals 4

    .prologue
    .line 78
    const-string/jumbo v0, "DirectedId: %s, Display Name: %s, userdata: %s, tokens: %s"

    const/4 v1, 0x4

    new-array v1, v1, [Ljava/lang/Object;

    const/4 v2, 0x0

    iget-object v3, p0, Lcom/amazon/identity/auth/device/storage/AccountInfo;->directedId:Ljava/lang/String;

    aput-object v3, v1, v2

    const/4 v2, 0x1

    iget-object v3, p0, Lcom/amazon/identity/auth/device/storage/AccountInfo;->displayName:Ljava/lang/String;

    aput-object v3, v1, v2

    const/4 v2, 0x2

    iget-object v3, p0, Lcom/amazon/identity/auth/device/storage/AccountInfo;->userdata:Ljava/util/Map;

    invoke-virtual {v3}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v3

    aput-object v3, v1, v2

    const/4 v2, 0x3

    iget-object v3, p0, Lcom/amazon/identity/auth/device/storage/AccountInfo;->tokens:Ljava/util/Map;

    invoke-virtual {v3}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v3

    aput-object v3, v1, v2

    invoke-static {v0, v1}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
