.class Ljr$1;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lno;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Ljr;->c()V
.end annotation


# instance fields
.field final synthetic a:Ljr;


# direct methods
.method constructor <init>(Ljr;)V
    .locals 0

    .prologue
    .line 90
    iput-object p1, p0, Ljr$1;->a:Ljr;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a()V
    .locals 1

    .prologue
    .line 93
    iget-object v0, p0, Ljr$1;->a:Ljr;

    invoke-virtual {v0}, Ljr;->d()V

    .line 94
    return-void
.end method
