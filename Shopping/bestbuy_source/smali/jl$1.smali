.class Ljl$1;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lno;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Ljl;->c()V
.end annotation


# instance fields
.field final synthetic a:Ljl;


# direct methods
.method constructor <init>(Ljl;)V
    .locals 0

    .prologue
    .line 65
    iput-object p1, p0, Ljl$1;->a:Ljl;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a()V
    .locals 1

    .prologue
    .line 68
    iget-object v0, p0, Ljl$1;->a:Ljl;

    invoke-virtual {v0}, Ljl;->d()V

    .line 69
    return-void
.end method
