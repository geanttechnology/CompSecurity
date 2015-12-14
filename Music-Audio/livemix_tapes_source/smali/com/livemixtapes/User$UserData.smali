.class public final Lcom/livemixtapes/User$UserData;
.super Ljava/lang/Object;
.source "User.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/livemixtapes/User;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = "UserData"
.end annotation


# instance fields
.field public final favoriteMixtapeIds:Ljava/util/Set;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Set",
            "<",
            "Ljava/lang/Integer;",
            ">;"
        }
    .end annotation
.end field

.field public final favoriteMixtapes:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Object;",
            ">;>;"
        }
    .end annotation
.end field

.field public final firstName:Ljava/lang/String;

.field public final lastName:Ljava/lang/String;

.field public playlists:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Object;",
            ">;>;"
        }
    .end annotation
.end field

.field public final radioFavoritesListId:I

.field public final userId:I

.field public final userName:Ljava/lang/String;


# direct methods
.method public constructor <init>(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;ILjava/util/List;Ljava/util/List;)V
    .locals 4
    .param p1, "userName"    # Ljava/lang/String;
    .param p2, "userId"    # I
    .param p3, "firstName"    # Ljava/lang/String;
    .param p4, "lastName"    # Ljava/lang/String;
    .param p5, "radioFavoritesListId"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "I",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "I",
            "Ljava/util/List",
            "<",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Object;",
            ">;>;",
            "Ljava/util/List",
            "<",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Object;",
            ">;>;)V"
        }
    .end annotation

    .prologue
    .line 41
    .local p6, "playLists":Ljava/util/List;, "Ljava/util/List<Ljava/util/Map<Ljava/lang/String;Ljava/lang/Object;>;>;"
    .local p7, "favoriteMixtapes":Ljava/util/List;, "Ljava/util/List<Ljava/util/Map<Ljava/lang/String;Ljava/lang/Object;>;>;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 45
    iput-object p1, p0, Lcom/livemixtapes/User$UserData;->userName:Ljava/lang/String;

    .line 46
    iput p2, p0, Lcom/livemixtapes/User$UserData;->userId:I

    .line 47
    iput-object p3, p0, Lcom/livemixtapes/User$UserData;->firstName:Ljava/lang/String;

    .line 48
    iput-object p4, p0, Lcom/livemixtapes/User$UserData;->lastName:Ljava/lang/String;

    .line 49
    iput p5, p0, Lcom/livemixtapes/User$UserData;->radioFavoritesListId:I

    .line 50
    iput-object p6, p0, Lcom/livemixtapes/User$UserData;->playlists:Ljava/util/List;

    .line 51
    iput-object p7, p0, Lcom/livemixtapes/User$UserData;->favoriteMixtapes:Ljava/util/List;

    .line 52
    const-string v2, "Nithin"

    invoke-virtual {p7}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 54
    new-instance v2, Ljava/util/HashSet;

    invoke-direct {v2}, Ljava/util/HashSet;-><init>()V

    iput-object v2, p0, Lcom/livemixtapes/User$UserData;->favoriteMixtapeIds:Ljava/util/Set;

    .line 56
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    invoke-interface {p7}, Ljava/util/List;->size()I

    move-result v2

    if-lt v0, v2, :cond_0

    .line 60
    return-void

    .line 57
    :cond_0
    invoke-interface {p7, v0}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/util/Map;

    const-string v3, "id"

    invoke-interface {v2, v3}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    .line 58
    .local v1, "id":Ljava/lang/String;
    iget-object v2, p0, Lcom/livemixtapes/User$UserData;->favoriteMixtapeIds:Ljava/util/Set;

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(Ljava/lang/String;)Ljava/lang/Integer;

    move-result-object v3

    invoke-interface {v2, v3}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 56
    add-int/lit8 v0, v0, 0x1

    goto :goto_0
.end method
