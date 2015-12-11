.class public Lc;
.super Ljava/lang/Object;
.source "SourceFile"


# instance fields
.field private a:Ljava/lang/String;

.field private b:Landroid/content/Context;

.field private c:Ljava/lang/String;

.field private d:Ljava/lang/String;

.field private e:Z

.field private f:Lf;

.field private g:Z


# direct methods
.method private constructor <init>()V
    .locals 1

    .prologue
    .line 51
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 49
    const/4 v0, 0x1

    iput-boolean v0, p0, Lc;->g:Z

    .line 52
    const-string v0, "https://mobile.eum-appdynamics.com"

    iput-object v0, p0, Lc;->c:Ljava/lang/String;

    .line 53
    const-string v0, "https://mobile-config.eum-appdynamics.com"

    iput-object v0, p0, Lc;->d:Ljava/lang/String;

    .line 54
    const/4 v0, 0x0

    iput-boolean v0, p0, Lc;->e:Z

    .line 55
    new-instance v0, Lc$1;

    invoke-direct {v0, p0}, Lc$1;-><init>(Lc;)V

    iput-object v0, p0, Lc;->f:Lf;

    .line 61
    return-void
.end method

.method synthetic constructor <init>(Lb$1;)V
    .locals 0

    .prologue
    .line 39
    invoke-direct {p0}, Lc;-><init>()V

    return-void
.end method


# virtual methods
.method public a()Lb;
    .locals 8

    .prologue
    .line 149
    iget-object v0, p0, Lc;->f:Lf;

    if-nez v0, :cond_0

    .line 150
    new-instance v0, Ljava/lang/NullPointerException;

    const-string v1, "collectorChannelFactory may not be null"

    invoke-direct {v0, v1}, Ljava/lang/NullPointerException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 152
    :cond_0
    new-instance v0, Lb;

    iget-object v1, p0, Lc;->a:Ljava/lang/String;

    iget-object v2, p0, Lc;->b:Landroid/content/Context;

    iget-object v3, p0, Lc;->c:Ljava/lang/String;

    iget-object v4, p0, Lc;->d:Ljava/lang/String;

    iget-boolean v5, p0, Lc;->e:Z

    iget-object v6, p0, Lc;->f:Lf;

    iget-boolean v7, p0, Lc;->g:Z

    invoke-direct/range {v0 .. v7}, Lb;-><init>(Ljava/lang/String;Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;ZLf;Z)V

    return-object v0
.end method

.method public a(Landroid/content/Context;)Lc;
    .locals 0

    .prologue
    .line 80
    iput-object p1, p0, Lc;->b:Landroid/content/Context;

    .line 81
    return-object p0
.end method

.method public a(Ljava/lang/String;)Lc;
    .locals 0

    .prologue
    .line 69
    iput-object p1, p0, Lc;->a:Ljava/lang/String;

    .line 70
    return-object p0
.end method
