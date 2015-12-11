.class final Luk/co/senab/actionbarpulltorefresh/library/m;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/lang/Runnable;


# instance fields
.field final synthetic a:Luk/co/senab/actionbarpulltorefresh/library/j;


# direct methods
.method constructor <init>(Luk/co/senab/actionbarpulltorefresh/library/j;)V
    .locals 0

    .prologue
    .line 643
    iput-object p1, p0, Luk/co/senab/actionbarpulltorefresh/library/m;->a:Luk/co/senab/actionbarpulltorefresh/library/j;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final run()V
    .locals 2

    .prologue
    .line 646
    iget-object v0, p0, Luk/co/senab/actionbarpulltorefresh/library/m;->a:Luk/co/senab/actionbarpulltorefresh/library/j;

    invoke-virtual {v0}, Luk/co/senab/actionbarpulltorefresh/library/j;->d()Z

    move-result v1

    if-nez v1, :cond_0

    iget-object v0, v0, Luk/co/senab/actionbarpulltorefresh/library/j;->a:Luk/co/senab/actionbarpulltorefresh/library/f;

    invoke-virtual {v0}, Luk/co/senab/actionbarpulltorefresh/library/f;->d()V

    .line 647
    :cond_0
    return-void
.end method
