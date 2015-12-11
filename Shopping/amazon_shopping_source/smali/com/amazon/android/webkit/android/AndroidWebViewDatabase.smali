.class public Lcom/amazon/android/webkit/android/AndroidWebViewDatabase;
.super Lcom/amazon/android/webkit/AmazonWebViewDatabase;
.source "AndroidWebViewDatabase.java"


# instance fields
.field private context:Landroid/content/Context;


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 0
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 17
    invoke-direct {p0}, Lcom/amazon/android/webkit/AmazonWebViewDatabase;-><init>()V

    .line 18
    iput-object p1, p0, Lcom/amazon/android/webkit/android/AndroidWebViewDatabase;->context:Landroid/content/Context;

    .line 19
    return-void
.end method
