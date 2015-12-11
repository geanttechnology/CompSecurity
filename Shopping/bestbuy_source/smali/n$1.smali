.class final Ln$1;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Ln;->run()V
.end annotation


# instance fields
.field private synthetic a:Lbk;


# direct methods
.method constructor <init>(Ln;Lbk;)V
    .locals 0

    .prologue
    .line 409
    iput-object p2, p0, Ln$1;->a:Lbk;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final run()V
    .locals 2

    .prologue
    .line 412
    iget-object v0, p0, Ln$1;->a:Lbk;

    const/16 v1, 0x2710

    invoke-virtual {v0, v1}, Lbk;->a(I)V

    .line 414
    return-void
.end method
