.class Ljz$1;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lno;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Ljz;->c()V
.end annotation


# instance fields
.field final synthetic a:Ljz;


# direct methods
.method constructor <init>(Ljz;)V
    .locals 0

    .prologue
    .line 60
    iput-object p1, p0, Ljz$1;->a:Ljz;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a()V
    .locals 1

    .prologue
    .line 63
    iget-object v0, p0, Ljz$1;->a:Ljz;

    invoke-virtual {v0}, Ljz;->d()V

    .line 64
    return-void
.end method
