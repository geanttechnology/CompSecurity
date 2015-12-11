.class public Lcom/amazon/retailsearch/android/ui/results/views/twister/TwisterModel$Edition;
.super Ljava/lang/Object;
.source "TwisterModel.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/retailsearch/android/ui/results/views/twister/TwisterModel;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4
    name = "Edition"
.end annotation


# instance fields
.field public asin:Ljava/lang/String;

.field protected price:Ljava/lang/String;

.field protected resultItem:Lcom/amazon/retailsearch/android/api/display/results/item/RetailSearchResultItem;

.field protected srdsBadgeId:Ljava/lang/String;

.field protected text:Ljava/lang/String;

.field final synthetic this$0:Lcom/amazon/retailsearch/android/ui/results/views/twister/TwisterModel;


# direct methods
.method public constructor <init>(Lcom/amazon/retailsearch/android/ui/results/views/twister/TwisterModel;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/amazon/retailsearch/android/api/display/results/item/RetailSearchResultItem;)V
    .locals 0
    .param p2, "text"    # Ljava/lang/String;
    .param p3, "price"    # Ljava/lang/String;
    .param p4, "srdsBadgeId"    # Ljava/lang/String;
    .param p5, "resultItem"    # Lcom/amazon/retailsearch/android/api/display/results/item/RetailSearchResultItem;

    .prologue
    .line 196
    iput-object p1, p0, Lcom/amazon/retailsearch/android/ui/results/views/twister/TwisterModel$Edition;->this$0:Lcom/amazon/retailsearch/android/ui/results/views/twister/TwisterModel;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 197
    iput-object p2, p0, Lcom/amazon/retailsearch/android/ui/results/views/twister/TwisterModel$Edition;->text:Ljava/lang/String;

    .line 198
    iput-object p3, p0, Lcom/amazon/retailsearch/android/ui/results/views/twister/TwisterModel$Edition;->price:Ljava/lang/String;

    .line 199
    iput-object p4, p0, Lcom/amazon/retailsearch/android/ui/results/views/twister/TwisterModel$Edition;->srdsBadgeId:Ljava/lang/String;

    .line 200
    iput-object p5, p0, Lcom/amazon/retailsearch/android/ui/results/views/twister/TwisterModel$Edition;->resultItem:Lcom/amazon/retailsearch/android/api/display/results/item/RetailSearchResultItem;

    .line 201
    return-void
.end method
