.class Ljo$1;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lno;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Ljo;->c()V
.end annotation


# instance fields
.field final synthetic a:Ljo;


# direct methods
.method constructor <init>(Ljo;)V
    .locals 0

    .prologue
    .line 65
    iput-object p1, p0, Ljo$1;->a:Ljo;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a()V
    .locals 1

    .prologue
    .line 68
    iget-object v0, p0, Ljo$1;->a:Ljo;

    invoke-virtual {v0}, Ljo;->d()V

    .line 69
    return-void
.end method
