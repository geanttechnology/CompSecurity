.class Ljx$1;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lno;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Ljx;->c()V
.end annotation


# instance fields
.field final synthetic a:Ljx;


# direct methods
.method constructor <init>(Ljx;)V
    .locals 0

    .prologue
    .line 55
    iput-object p1, p0, Ljx$1;->a:Ljx;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a()V
    .locals 1

    .prologue
    .line 58
    iget-object v0, p0, Ljx$1;->a:Ljx;

    invoke-virtual {v0}, Ljx;->d()V

    .line 59
    return-void
.end method
