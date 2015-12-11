.class public Lcom/poshmark/fb_tmblr_twitter/FBPermissionStates;
.super Ljava/lang/Object;
.source "FBPermissionStates.java"


# static fields
.field public static final EMAIL:I = 0x2

.field public static EMAIL_PERMISSION:Ljava/lang/String; = null

.field public static final FRIENDS:I = 0x4

.field public static FRIENDS_PERMISSION:Ljava/lang/String; = null

.field public static final NONE:I = 0x0

.field public static final PUBLISH:I = 0x8

.field public static PUBLISH_PERMISSION:Ljava/lang/String; = null

.field public static final READ:I = 0x1

.field public static READ_PERMISSION:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 16
    const-string v0, "public_profile"

    sput-object v0, Lcom/poshmark/fb_tmblr_twitter/FBPermissionStates;->READ_PERMISSION:Ljava/lang/String;

    .line 17
    const-string v0, "email"

    sput-object v0, Lcom/poshmark/fb_tmblr_twitter/FBPermissionStates;->EMAIL_PERMISSION:Ljava/lang/String;

    .line 18
    const-string v0, "user_friends"

    sput-object v0, Lcom/poshmark/fb_tmblr_twitter/FBPermissionStates;->FRIENDS_PERMISSION:Ljava/lang/String;

    .line 19
    const-string v0, "publish_actions"

    sput-object v0, Lcom/poshmark/fb_tmblr_twitter/FBPermissionStates;->PUBLISH_PERMISSION:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 9
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static getMaskFromString(Ljava/lang/String;)I
    .locals 2
    .param p0, "permission"    # Ljava/lang/String;

    .prologue
    .line 22
    const/4 v0, 0x0

    .line 23
    .local v0, "mask":I
    const-string v1, "public_profile"

    invoke-virtual {p0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 24
    or-int/lit8 v0, v0, 0x1

    .line 34
    :cond_0
    :goto_0
    return v0

    .line 25
    :cond_1
    const-string v1, "email"

    invoke-virtual {p0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_2

    .line 26
    or-int/lit8 v0, v0, 0x2

    goto :goto_0

    .line 28
    :cond_2
    const-string v1, "publish_actions"

    invoke-virtual {p0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_3

    .line 29
    or-int/lit8 v0, v0, 0x8

    goto :goto_0

    .line 31
    :cond_3
    const-string v1, "user_friends"

    invoke-virtual {p0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 32
    or-int/lit8 v0, v0, 0x4

    goto :goto_0
.end method

.method public static getPermissionStringSet(I)Ljava/util/Set;
    .locals 2
    .param p0, "accessLevel"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I)",
            "Ljava/util/Set",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 38
    new-instance v0, Ljava/util/HashSet;

    invoke-direct {v0}, Ljava/util/HashSet;-><init>()V

    .line 39
    .local v0, "permissions":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/String;>;"
    and-int/lit8 v1, p0, 0x1

    if-eqz v1, :cond_0

    .line 40
    const-string v1, "public_profile"

    invoke-interface {v0, v1}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 42
    :cond_0
    and-int/lit8 v1, p0, 0x2

    if-eqz v1, :cond_1

    .line 43
    const-string v1, "email"

    invoke-interface {v0, v1}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 45
    :cond_1
    and-int/lit8 v1, p0, 0x8

    if-eqz v1, :cond_2

    .line 46
    const-string v1, "publish_actions"

    invoke-interface {v0, v1}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 48
    :cond_2
    and-int/lit8 v1, p0, 0x4

    if-eqz v1, :cond_3

    .line 49
    const-string v1, "user_friends"

    invoke-interface {v0, v1}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 51
    :cond_3
    return-object v0
.end method
