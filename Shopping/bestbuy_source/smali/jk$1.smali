.class Ljk$1;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lno;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Ljk;->c()V
.end annotation


# instance fields
.field final synthetic a:Ljk;


# direct methods
.method constructor <init>(Ljk;)V
    .locals 0

    .prologue
    .line 69
    iput-object p1, p0, Ljk$1;->a:Ljk;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a()V
    .locals 1

    .prologue
    .line 72
    iget-object v0, p0, Ljk$1;->a:Ljk;

    invoke-virtual {v0}, Ljk;->d()V

    .line 73
    return-void
.end method
