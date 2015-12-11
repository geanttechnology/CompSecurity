.class public final Ltz;
.super Ljava/lang/Object;


# annotations
.annotation runtime Lzf;
.end annotation


# static fields
.field public static final a:Ljava/lang/String;


# instance fields
.field private final b:Ljava/util/Date;

.field private final c:Ljava/lang/String;

.field private final d:I

.field private final e:Ljava/util/Set;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Set",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private final f:Landroid/location/Location;

.field private final g:Z

.field private final h:Landroid/os/Bundle;

.field private final i:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
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

.field private final j:Ljava/lang/String;

.field private final k:Lpj;

.field private final l:I

.field private final m:Ljava/util/Set;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Set",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 1

    const-string v0, "emulator"

    invoke-static {v0}, Laca;->a(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    sput-object v0, Ltz;->a:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>(Lua;)V
    .locals 1

    const/4 v0, 0x0

    invoke-direct {p0, p1, v0}, Ltz;-><init>(Lua;Lpj;)V

    return-void
.end method

.method public constructor <init>(Lua;Lpj;)V
    .locals 1

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    invoke-static {p1}, Lua;->a(Lua;)Ljava/util/Date;

    move-result-object v0

    iput-object v0, p0, Ltz;->b:Ljava/util/Date;

    invoke-static {p1}, Lua;->b(Lua;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Ltz;->c:Ljava/lang/String;

    invoke-static {p1}, Lua;->c(Lua;)I

    move-result v0

    iput v0, p0, Ltz;->d:I

    invoke-static {p1}, Lua;->d(Lua;)Ljava/util/HashSet;

    move-result-object v0

    invoke-static {v0}, Ljava/util/Collections;->unmodifiableSet(Ljava/util/Set;)Ljava/util/Set;

    move-result-object v0

    iput-object v0, p0, Ltz;->e:Ljava/util/Set;

    invoke-static {p1}, Lua;->e(Lua;)Landroid/location/Location;

    move-result-object v0

    iput-object v0, p0, Ltz;->f:Landroid/location/Location;

    invoke-static {p1}, Lua;->f(Lua;)Z

    move-result v0

    iput-boolean v0, p0, Ltz;->g:Z

    invoke-static {p1}, Lua;->g(Lua;)Landroid/os/Bundle;

    move-result-object v0

    iput-object v0, p0, Ltz;->h:Landroid/os/Bundle;

    invoke-static {p1}, Lua;->h(Lua;)Ljava/util/HashMap;

    move-result-object v0

    invoke-static {v0}, Ljava/util/Collections;->unmodifiableMap(Ljava/util/Map;)Ljava/util/Map;

    move-result-object v0

    iput-object v0, p0, Ltz;->i:Ljava/util/Map;

    invoke-static {p1}, Lua;->i(Lua;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Ltz;->j:Ljava/lang/String;

    iput-object p2, p0, Ltz;->k:Lpj;

    invoke-static {p1}, Lua;->j(Lua;)I

    move-result v0

    iput v0, p0, Ltz;->l:I

    invoke-static {p1}, Lua;->k(Lua;)Ljava/util/HashSet;

    move-result-object v0

    invoke-static {v0}, Ljava/util/Collections;->unmodifiableSet(Ljava/util/Set;)Ljava/util/Set;

    move-result-object v0

    iput-object v0, p0, Ltz;->m:Ljava/util/Set;

    return-void
.end method


# virtual methods
.method public a(Ljava/lang/Class;)Landroid/os/Bundle;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Class",
            "<+",
            "Loz;",
            ">;)",
            "Landroid/os/Bundle;"
        }
    .end annotation

    iget-object v0, p0, Ltz;->h:Landroid/os/Bundle;

    invoke-virtual {p1}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getBundle(Ljava/lang/String;)Landroid/os/Bundle;

    move-result-object v0

    return-object v0
.end method

.method public a()Ljava/util/Date;
    .locals 1

    iget-object v0, p0, Ltz;->b:Ljava/util/Date;

    return-object v0
.end method

.method public a(Landroid/content/Context;)Z
    .locals 2

    iget-object v0, p0, Ltz;->m:Ljava/util/Set;

    invoke-static {p1}, Laca;->a(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1}, Ljava/util/Set;->contains(Ljava/lang/Object;)Z

    move-result v0

    return v0
.end method

.method public b()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Ltz;->c:Ljava/lang/String;

    return-object v0
.end method

.method public c()I
    .locals 1

    iget v0, p0, Ltz;->d:I

    return v0
.end method

.method public d()Ljava/util/Set;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Set",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    iget-object v0, p0, Ltz;->e:Ljava/util/Set;

    return-object v0
.end method

.method public e()Landroid/location/Location;
    .locals 1

    iget-object v0, p0, Ltz;->f:Landroid/location/Location;

    return-object v0
.end method

.method public f()Z
    .locals 1

    iget-boolean v0, p0, Ltz;->g:Z

    return v0
.end method

.method public g()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Ltz;->j:Ljava/lang/String;

    return-object v0
.end method

.method public h()Lpj;
    .locals 1

    iget-object v0, p0, Ltz;->k:Lpj;

    return-object v0
.end method

.method public i()Ljava/util/Map;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/Class",
            "<+",
            "Ljava/lang/Object;",
            ">;",
            "Ljava/lang/Object;",
            ">;"
        }
    .end annotation

    iget-object v0, p0, Ltz;->i:Ljava/util/Map;

    return-object v0
.end method

.method public j()Landroid/os/Bundle;
    .locals 1

    iget-object v0, p0, Ltz;->h:Landroid/os/Bundle;

    return-object v0
.end method

.method public k()I
    .locals 1

    iget v0, p0, Ltz;->l:I

    return v0
.end method
