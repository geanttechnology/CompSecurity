.class public Lsu;
.super Ljava/lang/Object;

# interfaces
.implements Lsr;


# annotations
.annotation runtime Lzf;
.end annotation


# instance fields
.field private final a:Lcom/google/android/gms/internal/gu;


# direct methods
.method public constructor <init>(Landroid/content/Context;Lcom/google/android/gms/internal/gs;)V
    .locals 6

    const/4 v2, 0x0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    new-instance v1, Lcom/google/android/gms/internal/ay;

    invoke-direct {v1}, Lcom/google/android/gms/internal/ay;-><init>()V

    const/4 v4, 0x0

    move-object v0, p1

    move v3, v2

    move-object v5, p2

    invoke-static/range {v0 .. v5}, Lcom/google/android/gms/internal/gu;->a(Landroid/content/Context;Lcom/google/android/gms/internal/ay;ZZLaea;Lcom/google/android/gms/internal/gs;)Lcom/google/android/gms/internal/gu;

    move-result-object v0

    iput-object v0, p0, Lsu;->a:Lcom/google/android/gms/internal/gu;

    return-void
.end method

.method static synthetic a(Lsu;)Lcom/google/android/gms/internal/gu;
    .locals 1

    iget-object v0, p0, Lsu;->a:Lcom/google/android/gms/internal/gu;

    return-object v0
.end method

.method private a(Ljava/lang/Runnable;)V
    .locals 1

    invoke-static {}, Laca;->b()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-interface {p1}, Ljava/lang/Runnable;->run()V

    :goto_0
    return-void

    :cond_0
    sget-object v0, Laca;->a:Landroid/os/Handler;

    invoke-virtual {v0, p1}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    goto :goto_0
.end method


# virtual methods
.method public a()V
    .locals 1

    iget-object v0, p0, Lsu;->a:Lcom/google/android/gms/internal/gu;

    invoke-static {v0}, Labq;->a(Landroid/webkit/WebView;)V

    return-void
.end method

.method public a(Lahh;Lxh;Lvb;Lxj;ZLve;)V
    .locals 8

    iget-object v0, p0, Lsu;->a:Lcom/google/android/gms/internal/gu;

    invoke-virtual {v0}, Lcom/google/android/gms/internal/gu;->f()Lace;

    move-result-object v0

    new-instance v7, Lahl;

    const/4 v1, 0x0

    invoke-direct {v7, v1}, Lahl;-><init>(Z)V

    move-object v1, p1

    move-object v2, p2

    move-object v3, p3

    move-object v4, p4

    move v5, p5

    move-object v6, p6

    invoke-virtual/range {v0 .. v7}, Lace;->a(Lahh;Lxh;Lvb;Lxj;ZLve;Lahl;)V

    return-void
.end method

.method public a(Ljava/lang/String;)V
    .locals 1

    new-instance v0, Lsu$2;

    invoke-direct {v0, p0, p1}, Lsu$2;-><init>(Lsu;Ljava/lang/String;)V

    invoke-direct {p0, v0}, Lsu;->a(Ljava/lang/Runnable;)V

    return-void
.end method

.method public a(Ljava/lang/String;Lorg/json/JSONObject;)V
    .locals 1

    new-instance v0, Lsu$1;

    invoke-direct {v0, p0, p1, p2}, Lsu$1;-><init>(Lsu;Ljava/lang/String;Lorg/json/JSONObject;)V

    invoke-direct {p0, v0}, Lsu;->a(Ljava/lang/Runnable;)V

    return-void
.end method

.method public a(Ljava/lang/String;Lvd;)V
    .locals 1

    iget-object v0, p0, Lsu;->a:Lcom/google/android/gms/internal/gu;

    invoke-virtual {v0}, Lcom/google/android/gms/internal/gu;->f()Lace;

    move-result-object v0

    invoke-virtual {v0, p1, p2}, Lace;->a(Ljava/lang/String;Lvd;)V

    return-void
.end method

.method public a(Lss;)V
    .locals 2

    iget-object v0, p0, Lsu;->a:Lcom/google/android/gms/internal/gu;

    invoke-virtual {v0}, Lcom/google/android/gms/internal/gu;->f()Lace;

    move-result-object v0

    new-instance v1, Lsu$3;

    invoke-direct {v1, p0, p1}, Lsu$3;-><init>(Lsu;Lss;)V

    invoke-virtual {v0, v1}, Lace;->a(Lacf;)V

    return-void
.end method

.method public b()V
    .locals 1

    iget-object v0, p0, Lsu;->a:Lcom/google/android/gms/internal/gu;

    invoke-static {v0}, Labq;->b(Landroid/webkit/WebView;)V

    return-void
.end method

.method public b(Ljava/lang/String;)V
    .locals 2

    iget-object v0, p0, Lsu;->a:Lcom/google/android/gms/internal/gu;

    invoke-virtual {v0}, Lcom/google/android/gms/internal/gu;->f()Lace;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {v0, p1, v1}, Lace;->a(Ljava/lang/String;Lvd;)V

    return-void
.end method

.method public c()V
    .locals 1

    iget-object v0, p0, Lsu;->a:Lcom/google/android/gms/internal/gu;

    invoke-virtual {v0}, Lcom/google/android/gms/internal/gu;->destroy()V

    return-void
.end method
