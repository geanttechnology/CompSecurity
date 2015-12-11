.class public Lnm;
.super Ljava/lang/Object;
.source "SourceFile"


# static fields
.field public static a:Landroid/app/Dialog;

.field public static b:Lkq;

.field public static c:Lld;

.field public static d:Z

.field private static final e:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 16
    const-class v0, Lnm;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lnm;->e:Ljava/lang/String;

    .line 17
    sput-object v1, Lnm;->a:Landroid/app/Dialog;

    .line 18
    sput-object v1, Lnm;->b:Lkq;

    .line 19
    sput-object v1, Lnm;->c:Lld;

    .line 20
    const/4 v0, 0x0

    sput-boolean v0, Lnm;->d:Z

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 15
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 77
    return-void
.end method

.method public static a(Landroid/content/Context;Lnn;)V
    .locals 1

    .prologue
    .line 24
    new-instance v0, Lnm$1;

    invoke-direct {v0, p1}, Lnm$1;-><init>(Lnn;)V

    invoke-static {p0, v0}, Lnm;->b(Landroid/content/Context;Lnn;)V

    .line 30
    return-void
.end method

.method public static a(Landroid/content/Context;Lno;)V
    .locals 1

    .prologue
    .line 89
    new-instance v0, Lkz;

    invoke-direct {v0, p0, p1}, Lkz;-><init>(Landroid/content/Context;Lno;)V

    sput-object v0, Lnm;->a:Landroid/app/Dialog;

    .line 90
    sget-object v0, Lnm;->a:Landroid/app/Dialog;

    invoke-virtual {v0}, Landroid/app/Dialog;->show()V

    .line 91
    return-void
.end method

.method private static a(Landroid/content/Context;Lno;Lnn;)V
    .locals 1

    .prologue
    .line 48
    if-eqz p0, :cond_0

    move-object v0, p0

    check-cast v0, Landroid/app/Activity;

    invoke-virtual {v0}, Landroid/app/Activity;->isFinishing()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 53
    :cond_0
    :goto_0
    return-void

    .line 51
    :cond_1
    new-instance v0, Lkq;

    invoke-direct {v0, p0, p1, p2}, Lkq;-><init>(Landroid/content/Context;Lno;Lnn;)V

    sput-object v0, Lnm;->b:Lkq;

    .line 52
    sget-object v0, Lnm;->b:Lkq;

    invoke-virtual {v0}, Lkq;->a()V

    goto :goto_0
.end method

.method public static a(Landroid/content/Context;Lno;Lnn;ZI)V
    .locals 0

    .prologue
    .line 35
    if-nez p3, :cond_1

    .line 36
    if-nez p4, :cond_0

    .line 37
    invoke-static {p0, p1, p2}, Lnm;->a(Landroid/content/Context;Lno;Lnn;)V

    .line 44
    :goto_0
    return-void

    .line 39
    :cond_0
    invoke-static {p0, p2}, Lnm;->a(Landroid/content/Context;Lnn;)V

    goto :goto_0

    .line 42
    :cond_1
    invoke-static {p0, p1}, Lnm;->a(Landroid/content/Context;Lno;)V

    goto :goto_0
.end method

.method private static b(Landroid/content/Context;Lnn;)V
    .locals 1

    .prologue
    .line 56
    if-eqz p0, :cond_0

    move-object v0, p0

    check-cast v0, Landroid/app/Activity;

    invoke-virtual {v0}, Landroid/app/Activity;->isFinishing()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 61
    :cond_0
    :goto_0
    return-void

    .line 59
    :cond_1
    new-instance v0, Lld;

    invoke-direct {v0, p0, p1}, Lld;-><init>(Landroid/content/Context;Lnn;)V

    sput-object v0, Lnm;->c:Lld;

    .line 60
    sget-object v0, Lnm;->c:Lld;

    invoke-virtual {v0}, Lld;->a()V

    goto :goto_0
.end method
