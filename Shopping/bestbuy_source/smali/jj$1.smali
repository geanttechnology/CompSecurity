.class Ljj$1;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lno;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Ljj;->c()V
.end annotation


# instance fields
.field final synthetic a:Ljj;


# direct methods
.method constructor <init>(Ljj;)V
    .locals 0

    .prologue
    .line 80
    iput-object p1, p0, Ljj$1;->a:Ljj;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a()V
    .locals 1

    .prologue
    .line 83
    iget-object v0, p0, Ljj$1;->a:Ljj;

    invoke-virtual {v0}, Ljj;->d()V

    .line 84
    return-void
.end method
