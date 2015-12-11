.class public Lhs;
.super Lka;
.source "SourceFile"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 10
    invoke-direct {p0}, Lka;-><init>()V

    .line 11
    return-void
.end method


# virtual methods
.method public a()V
    .locals 5

    .prologue
    .line 15
    invoke-static {}, Lnb;->a()Lnb;

    move-result-object v0

    invoke-virtual {v0}, Lnb;->s()Ljava/lang/String;

    move-result-object v0

    .line 16
    invoke-static {}, Lnb;->q()Ljava/lang/String;

    move-result-object v1

    .line 17
    invoke-static {}, Lnb;->a()Lnb;

    move-result-object v2

    invoke-virtual {v2}, Lnb;->m()Ljava/lang/String;

    move-result-object v2

    .line 18
    sget-object v3, Landroid/os/Build;->MANUFACTURER:Ljava/lang/String;

    .line 20
    if-eqz v0, :cond_0

    :try_start_0
    invoke-virtual {v0}, Ljava/lang/String;->isEmpty()Z

    move-result v4

    if-nez v4, :cond_0

    .line 21
    invoke-static {v0, v3, v2, v1}, Lfs;->d(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 25
    :cond_0
    :goto_0
    return-void

    .line 22
    :catch_0
    move-exception v0

    .line 23
    invoke-virtual {v0}, Ljava/lang/Exception;->printStackTrace()V

    goto :goto_0
.end method

.method public b()V
    .locals 0

    .prologue
    .line 30
    return-void
.end method
