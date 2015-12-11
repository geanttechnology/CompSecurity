.class public final Lua;
.super Ljava/lang/Object;


# instance fields
.field private final a:Ljava/util/HashSet;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashSet",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private final b:Landroid/os/Bundle;

.field private final c:Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/Class",
            "<+",
            "Ljava/lang/Object;",
            ">;",
            "Ljava/lang/Object;",
            ">;"
        }
    .end annotation
.end field

.field private final d:Ljava/util/HashSet;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashSet",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private e:Ljava/util/Date;

.field private f:Ljava/lang/String;

.field private g:I

.field private h:Landroid/location/Location;

.field private i:Z

.field private j:Ljava/lang/String;

.field private k:I


# direct methods
.method public constructor <init>()V
    .locals 2

    const/4 v1, -0x1

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    new-instance v0, Ljava/util/HashSet;

    invoke-direct {v0}, Ljava/util/HashSet;-><init>()V

    iput-object v0, p0, Lua;->a:Ljava/util/HashSet;

    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    iput-object v0, p0, Lua;->b:Landroid/os/Bundle;

    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lua;->c:Ljava/util/HashMap;

    new-instance v0, Ljava/util/HashSet;

    invoke-direct {v0}, Ljava/util/HashSet;-><init>()V

    iput-object v0, p0, Lua;->d:Ljava/util/HashSet;

    iput v1, p0, Lua;->g:I

    const/4 v0, 0x0

    iput-boolean v0, p0, Lua;->i:Z

    iput v1, p0, Lua;->k:I

    return-void
.end method

.method static synthetic a(Lua;)Ljava/util/Date;
    .locals 1

    iget-object v0, p0, Lua;->e:Ljava/util/Date;

    return-object v0
.end method

.method static synthetic b(Lua;)Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lua;->f:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic c(Lua;)I
    .locals 1

    iget v0, p0, Lua;->g:I

    return v0
.end method

.method static synthetic d(Lua;)Ljava/util/HashSet;
    .locals 1

    iget-object v0, p0, Lua;->a:Ljava/util/HashSet;

    return-object v0
.end method

.method static synthetic e(Lua;)Landroid/location/Location;
    .locals 1

    iget-object v0, p0, Lua;->h:Landroid/location/Location;

    return-object v0
.end method

.method static synthetic f(Lua;)Z
    .locals 1

    iget-boolean v0, p0, Lua;->i:Z

    return v0
.end method

.method static synthetic g(Lua;)Landroid/os/Bundle;
    .locals 1

    iget-object v0, p0, Lua;->b:Landroid/os/Bundle;

    return-object v0
.end method

.method static synthetic h(Lua;)Ljava/util/HashMap;
    .locals 1

    iget-object v0, p0, Lua;->c:Ljava/util/HashMap;

    return-object v0
.end method

.method static synthetic i(Lua;)Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lua;->j:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic j(Lua;)I
    .locals 1

    iget v0, p0, Lua;->k:I

    return v0
.end method

.method static synthetic k(Lua;)Ljava/util/HashSet;
    .locals 1

    iget-object v0, p0, Lua;->d:Ljava/util/HashSet;

    return-object v0
.end method


# virtual methods
.method public a(I)V
    .locals 0

    iput p1, p0, Lua;->g:I

    return-void
.end method

.method public a(Landroid/location/Location;)V
    .locals 0

    iput-object p1, p0, Lua;->h:Landroid/location/Location;

    return-void
.end method

.method public a(Ljava/lang/Class;Landroid/os/Bundle;)V
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Class",
            "<+",
            "Loz;",
            ">;",
            "Landroid/os/Bundle;",
            ")V"
        }
    .end annotation

    iget-object v0, p0, Lua;->b:Landroid/os/Bundle;

    invoke-virtual {p1}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1, p2}, Landroid/os/Bundle;->putBundle(Ljava/lang/String;Landroid/os/Bundle;)V

    return-void
.end method

.method public a(Ljava/lang/String;)V
    .locals 1

    iget-object v0, p0, Lua;->a:Ljava/util/HashSet;

    invoke-virtual {v0, p1}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    return-void
.end method

.method public a(Ljava/util/Date;)V
    .locals 0

    iput-object p1, p0, Lua;->e:Ljava/util/Date;

    return-void
.end method

.method public a(Z)V
    .locals 1

    if-eqz p1, :cond_0

    const/4 v0, 0x1

    :goto_0
    iput v0, p0, Lua;->k:I

    return-void

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public b(Ljava/lang/String;)V
    .locals 1

    iget-object v0, p0, Lua;->d:Ljava/util/HashSet;

    invoke-virtual {v0, p1}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    return-void
.end method
