.class Lcom/bestbuy/android/activities/registry/ListIdSearchFragment$3;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/content/DialogInterface$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/bestbuy/android/activities/registry/ListIdSearchFragment;->a(Ljava/util/ArrayList;)V
.end annotation


# instance fields
.field final synthetic a:Lcom/bestbuy/android/activities/registry/ListIdSearchFragment;


# direct methods
.method constructor <init>(Lcom/bestbuy/android/activities/registry/ListIdSearchFragment;)V
    .locals 0

    .prologue
    .line 199
    iput-object p1, p0, Lcom/bestbuy/android/activities/registry/ListIdSearchFragment$3;->a:Lcom/bestbuy/android/activities/registry/ListIdSearchFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/content/DialogInterface;I)V
    .locals 0

    .prologue
    .line 202
    invoke-interface {p1}, Landroid/content/DialogInterface;->dismiss()V

    .line 203
    return-void
.end method
