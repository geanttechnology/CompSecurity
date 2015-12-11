.class Ljs$1;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lno;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Ljs;->c()V
.end annotation


# instance fields
.field final synthetic a:Ljs;


# direct methods
.method constructor <init>(Ljs;)V
    .locals 0

    .prologue
    .line 80
    iput-object p1, p0, Ljs$1;->a:Ljs;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a()V
    .locals 1

    .prologue
    .line 83
    iget-object v0, p0, Ljs$1;->a:Ljs;

    invoke-virtual {v0}, Ljs;->d()V

    .line 84
    return-void
.end method
