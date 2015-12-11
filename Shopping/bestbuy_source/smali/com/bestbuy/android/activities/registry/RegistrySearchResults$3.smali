.class Lcom/bestbuy/android/activities/registry/RegistrySearchResults$3;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/content/DialogInterface$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/bestbuy/android/activities/registry/RegistrySearchResults;->a(Ljava/util/ArrayList;)V
.end annotation


# instance fields
.field final synthetic a:Lcom/bestbuy/android/activities/registry/RegistrySearchResults;


# direct methods
.method constructor <init>(Lcom/bestbuy/android/activities/registry/RegistrySearchResults;)V
    .locals 0

    .prologue
    .line 150
    iput-object p1, p0, Lcom/bestbuy/android/activities/registry/RegistrySearchResults$3;->a:Lcom/bestbuy/android/activities/registry/RegistrySearchResults;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/content/DialogInterface;I)V
    .locals 0

    .prologue
    .line 153
    invoke-interface {p1}, Landroid/content/DialogInterface;->dismiss()V

    .line 154
    return-void
.end method
