.class public final Lop;
.super Ljava/lang/Object;


# instance fields
.field private final a:Luc;


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 1

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    new-instance v0, Luc;

    invoke-direct {v0, p1}, Luc;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Lop;->a:Luc;

    return-void
.end method


# virtual methods
.method public a()V
    .locals 1

    iget-object v0, p0, Lop;->a:Luc;

    invoke-virtual {v0}, Luc;->a()V

    return-void
.end method

.method public a(Ljava/lang/String;)V
    .locals 1

    iget-object v0, p0, Lop;->a:Luc;

    invoke-virtual {v0, p1}, Luc;->a(Ljava/lang/String;)V

    return-void
.end method

.method public a(Lol;)V
    .locals 1

    iget-object v0, p0, Lop;->a:Luc;

    invoke-virtual {v0, p1}, Luc;->a(Lol;)V

    return-void
.end method

.method public a(Lom;)V
    .locals 2

    iget-object v0, p0, Lop;->a:Luc;

    invoke-virtual {p1}, Lom;->a()Ltz;

    move-result-object v1

    invoke-virtual {v0, v1}, Luc;->a(Ltz;)V

    return-void
.end method
