.class public final Luh;
.super Luk;


# annotations
.annotation runtime Lzf;
.end annotation


# instance fields
.field private final a:Laho;

.field private final b:Ljava/lang/String;

.field private final c:Ljava/lang/String;


# direct methods
.method public constructor <init>(Laho;Ljava/lang/String;Ljava/lang/String;)V
    .locals 0

    invoke-direct {p0}, Luk;-><init>()V

    iput-object p1, p0, Luh;->a:Laho;

    iput-object p2, p0, Luh;->b:Ljava/lang/String;

    iput-object p3, p0, Luh;->c:Ljava/lang/String;

    return-void
.end method


# virtual methods
.method public a()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Luh;->b:Ljava/lang/String;

    return-object v0
.end method

.method public a(Lry;)V
    .locals 2

    if-nez p1, :cond_0

    :goto_0
    return-void

    :cond_0
    iget-object v1, p0, Luh;->a:Laho;

    invoke-static {p1}, Lsb;->a(Lry;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/view/View;

    invoke-interface {v1, v0}, Laho;->a(Landroid/view/View;)V

    goto :goto_0
.end method

.method public b()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Luh;->c:Ljava/lang/String;

    return-object v0
.end method

.method public c()V
    .locals 1

    iget-object v0, p0, Luh;->a:Laho;

    invoke-interface {v0}, Laho;->u()V

    return-void
.end method

.method public d()V
    .locals 1

    iget-object v0, p0, Luh;->a:Laho;

    invoke-interface {v0}, Laho;->v()V

    return-void
.end method
