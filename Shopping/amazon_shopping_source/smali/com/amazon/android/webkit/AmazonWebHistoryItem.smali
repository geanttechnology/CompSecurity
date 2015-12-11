.class public Lcom/amazon/android/webkit/AmazonWebHistoryItem;
.super Ljava/lang/Object;
.source "AmazonWebHistoryItem.java"


# instance fields
.field private final favicon:Landroid/graphics/Bitmap;

.field private final flattenedData:[B

.field private final id:I

.field private final originalUrl:Ljava/lang/String;

.field private final title:Ljava/lang/String;

.field private final url:Ljava/lang/String;


# direct methods
.method public constructor <init>(Landroid/graphics/Bitmap;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;[B)V
    .locals 0
    .param p1, "favicon"    # Landroid/graphics/Bitmap;
    .param p2, "id"    # I
    .param p3, "originalUrl"    # Ljava/lang/String;
    .param p4, "title"    # Ljava/lang/String;
    .param p5, "url"    # Ljava/lang/String;
    .param p6, "flattenedData"    # [B

    .prologue
    .line 44
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 45
    iput-object p1, p0, Lcom/amazon/android/webkit/AmazonWebHistoryItem;->favicon:Landroid/graphics/Bitmap;

    .line 46
    iput p2, p0, Lcom/amazon/android/webkit/AmazonWebHistoryItem;->id:I

    .line 47
    iput-object p3, p0, Lcom/amazon/android/webkit/AmazonWebHistoryItem;->originalUrl:Ljava/lang/String;

    .line 48
    iput-object p4, p0, Lcom/amazon/android/webkit/AmazonWebHistoryItem;->title:Ljava/lang/String;

    .line 49
    iput-object p5, p0, Lcom/amazon/android/webkit/AmazonWebHistoryItem;->url:Ljava/lang/String;

    .line 50
    iput-object p6, p0, Lcom/amazon/android/webkit/AmazonWebHistoryItem;->flattenedData:[B

    .line 51
    return-void
.end method
