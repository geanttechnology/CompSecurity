.class Lcom/exacttarget/etpushsdk/b;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/view/View$OnClickListener;


# instance fields
.field final synthetic a:Lcom/exacttarget/etpushsdk/ETLandingPagePresenter;


# direct methods
.method constructor <init>(Lcom/exacttarget/etpushsdk/ETLandingPagePresenter;)V
    .locals 0

    .prologue
    .line 120
    iput-object p1, p0, Lcom/exacttarget/etpushsdk/b;->a:Lcom/exacttarget/etpushsdk/ETLandingPagePresenter;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 1

    .prologue
    .line 123
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/b;->a:Lcom/exacttarget/etpushsdk/ETLandingPagePresenter;

    invoke-virtual {v0}, Lcom/exacttarget/etpushsdk/ETLandingPagePresenter;->finish()V

    .line 124
    return-void
.end method
