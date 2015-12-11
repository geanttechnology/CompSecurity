.class Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings$3;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/content/DialogInterface$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->d()V
.end annotation


# instance fields
.field final synthetic a:Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;


# direct methods
.method constructor <init>(Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;)V
    .locals 0

    .prologue
    .line 231
    iput-object p1, p0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings$3;->a:Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/content/DialogInterface;I)V
    .locals 0

    .prologue
    .line 234
    invoke-interface {p1}, Landroid/content/DialogInterface;->dismiss()V

    .line 235
    return-void
.end method
