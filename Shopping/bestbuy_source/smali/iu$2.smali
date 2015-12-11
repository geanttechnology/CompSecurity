.class Liu$2;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lnn;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Liu;->c()V
.end annotation


# instance fields
.field final synthetic a:Liu;


# direct methods
.method constructor <init>(Liu;)V
    .locals 0

    .prologue
    .line 64
    iput-object p1, p0, Liu$2;->a:Liu;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a()V
    .locals 1

    .prologue
    .line 66
    const/4 v0, 0x0

    invoke-static {v0}, Liu;->a(I)I

    .line 67
    iget-object v0, p0, Liu$2;->a:Liu;

    invoke-static {v0}, Liu;->f(Liu;)Landroid/app/Activity;

    move-result-object v0

    check-cast v0, Landroid/support/v4/app/FragmentActivity;

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentManager;->popBackStack()V

    .line 68
    return-void
.end method
