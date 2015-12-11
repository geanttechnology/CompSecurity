.class Liz$1;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lno;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Liz;->c()V
.end annotation


# instance fields
.field final synthetic a:Liz;


# direct methods
.method constructor <init>(Liz;)V
    .locals 0

    .prologue
    .line 63
    iput-object p1, p0, Liz$1;->a:Liz;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a()V
    .locals 1

    .prologue
    .line 66
    iget-object v0, p0, Liz$1;->a:Liz;

    invoke-virtual {v0}, Liz;->d()V

    .line 67
    return-void
.end method
