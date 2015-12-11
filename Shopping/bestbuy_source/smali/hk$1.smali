.class Lhk$1;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lno;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lhk;->c()V
.end annotation


# instance fields
.field final synthetic a:Lhk;


# direct methods
.method constructor <init>(Lhk;)V
    .locals 0

    .prologue
    .line 50
    iput-object p1, p0, Lhk$1;->a:Lhk;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a()V
    .locals 1

    .prologue
    .line 53
    iget-object v0, p0, Lhk$1;->a:Lhk;

    invoke-virtual {v0}, Lhk;->d()V

    .line 54
    return-void
.end method
