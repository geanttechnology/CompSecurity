.class public final Lon;
.super Ljava/lang/Object;


# instance fields
.field private final a:Lua;


# direct methods
.method public constructor <init>()V
    .locals 1

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    new-instance v0, Lua;

    invoke-direct {v0}, Lua;-><init>()V

    iput-object v0, p0, Lon;->a:Lua;

    return-void
.end method

.method static synthetic a(Lon;)Lua;
    .locals 1

    iget-object v0, p0, Lon;->a:Lua;

    return-object v0
.end method


# virtual methods
.method public a()Lom;
    .locals 2

    new-instance v0, Lom;

    const/4 v1, 0x0

    invoke-direct {v0, p0, v1}, Lom;-><init>(Lon;Lom$1;)V

    return-object v0
.end method

.method public a(I)Lon;
    .locals 1

    iget-object v0, p0, Lon;->a:Lua;

    invoke-virtual {v0, p1}, Lua;->a(I)V

    return-object p0
.end method

.method public a(Landroid/location/Location;)Lon;
    .locals 1

    iget-object v0, p0, Lon;->a:Lua;

    invoke-virtual {v0, p1}, Lua;->a(Landroid/location/Location;)V

    return-object p0
.end method

.method public a(Ljava/lang/Class;Landroid/os/Bundle;)Lon;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Class",
            "<+",
            "Loz;",
            ">;",
            "Landroid/os/Bundle;",
            ")",
            "Lon;"
        }
    .end annotation

    iget-object v0, p0, Lon;->a:Lua;

    invoke-virtual {v0, p1, p2}, Lua;->a(Ljava/lang/Class;Landroid/os/Bundle;)V

    return-object p0
.end method

.method public a(Ljava/lang/String;)Lon;
    .locals 1

    iget-object v0, p0, Lon;->a:Lua;

    invoke-virtual {v0, p1}, Lua;->a(Ljava/lang/String;)V

    return-object p0
.end method

.method public a(Ljava/util/Date;)Lon;
    .locals 1

    iget-object v0, p0, Lon;->a:Lua;

    invoke-virtual {v0, p1}, Lua;->a(Ljava/util/Date;)V

    return-object p0
.end method

.method public a(Z)Lon;
    .locals 1

    iget-object v0, p0, Lon;->a:Lua;

    invoke-virtual {v0, p1}, Lua;->a(Z)V

    return-object p0
.end method

.method public b(Ljava/lang/String;)Lon;
    .locals 1

    iget-object v0, p0, Lon;->a:Lua;

    invoke-virtual {v0, p1}, Lua;->b(Ljava/lang/String;)V

    return-object p0
.end method
