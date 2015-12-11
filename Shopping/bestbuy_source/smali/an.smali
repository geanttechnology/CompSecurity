.class final Lan;
.super Ljava/lang/Object;
.source "SourceFile"


# instance fields
.field private final a:Ly;


# direct methods
.method constructor <init>(Ly;)V
    .locals 1

    .prologue
    .line 18
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 19
    iput-object p1, p0, Lan;->a:Ly;

    .line 20
    const/16 v0, 0xc8

    invoke-virtual {p1, v0}, Ly;->a(I)V

    .line 21
    return-void
.end method


# virtual methods
.method final a()Ljava/util/List;
    .locals 3

    .prologue
    .line 33
    invoke-static {}, Ljava/util/Collections;->emptyList()Ljava/util/List;

    move-result-object v0

    .line 35
    :try_start_0
    iget-object v1, p0, Lan;->a:Ly;

    invoke-virtual {v1}, Ly;->a()Ljava/util/List;
    :try_end_0
    .catch Ljava/lang/Throwable; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v0

    .line 42
    :try_start_1
    iget-object v1, p0, Lan;->a:Ly;

    invoke-virtual {v1}, Ly;->b()V
    :try_end_1
    .catch Ljava/lang/Throwable; {:try_start_1 .. :try_end_1} :catch_1

    .line 46
    :goto_0
    return-object v0

    .line 36
    :catch_0
    move-exception v1

    .line 37
    const-string v2, "Error reading beacons from database"

    invoke-static {v2, v1}, Lp;->a(Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0

    .line 43
    :catch_1
    move-exception v1

    .line 44
    const-string v2, "Error clearing beacons from database"

    invoke-static {v2, v1}, Lp;->a(Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0
.end method

.method final a(Ljava/util/List;)Z
    .locals 2

    .prologue
    .line 25
    :try_start_0
    iget-object v0, p0, Lan;->a:Ly;

    invoke-virtual {v0, p1}, Ly;->a(Ljava/util/List;)Z
    :try_end_0
    .catch Ljava/lang/Throwable; {:try_start_0 .. :try_end_0} :catch_0

    move-result v0

    .line 28
    :goto_0
    return v0

    .line 26
    :catch_0
    move-exception v0

    .line 27
    const-string v1, "Error writing beacons to database"

    invoke-static {v1, v0}, Lp;->a(Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 28
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public final b()V
    .locals 1

    .prologue
    .line 50
    iget-object v0, p0, Lan;->a:Ly;

    invoke-virtual {v0}, Ly;->c()V

    .line 51
    return-void
.end method
