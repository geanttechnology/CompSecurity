.class Lcom/amazon/android/webkit/android/AndroidWebKitFactory$1;
.super Lcom/amazon/android/webkit/AmazonHistoryManager;
.source "AndroidWebKitFactory.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/android/webkit/android/AndroidWebKitFactory;-><init>()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/android/webkit/android/AndroidWebKitFactory;


# direct methods
.method constructor <init>(Lcom/amazon/android/webkit/android/AndroidWebKitFactory;)V
    .locals 0

    .prologue
    .line 88
    iput-object p1, p0, Lcom/amazon/android/webkit/android/AndroidWebKitFactory$1;->this$0:Lcom/amazon/android/webkit/android/AndroidWebKitFactory;

    invoke-direct {p0}, Lcom/amazon/android/webkit/AmazonHistoryManager;-><init>()V

    return-void
.end method
