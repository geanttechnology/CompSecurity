.class public Lcom/amazon/mShop/wearable/wear/shared/StampedMessage;
.super Ljava/lang/Object;
.source "StampedMessage.java"


# static fields
.field private static final UTF_8:Ljava/nio/charset/Charset;


# instance fields
.field public mData:[B

.field public mId:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 7
    const-string/jumbo v0, "UTF-8"

    invoke-static {v0}, Ljava/nio/charset/Charset;->forName(Ljava/lang/String;)Ljava/nio/charset/Charset;

    move-result-object v0

    sput-object v0, Lcom/amazon/mShop/wearable/wear/shared/StampedMessage;->UTF_8:Ljava/nio/charset/Charset;

    return-void
.end method

.method public constructor <init>()V
    .locals 1

    .prologue
    .line 12
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 9
    invoke-static {}, Ljava/util/UUID;->randomUUID()Ljava/util/UUID;

    move-result-object v0

    invoke-virtual {v0}, Ljava/util/UUID;->toString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/mShop/wearable/wear/shared/StampedMessage;->mId:Ljava/lang/String;

    .line 10
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/amazon/mShop/wearable/wear/shared/StampedMessage;->mData:[B

    .line 13
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;[B)V
    .locals 1
    .param p1, "id"    # Ljava/lang/String;
    .param p2, "data"    # [B

    .prologue
    .line 19
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 9
    invoke-static {}, Ljava/util/UUID;->randomUUID()Ljava/util/UUID;

    move-result-object v0

    invoke-virtual {v0}, Ljava/util/UUID;->toString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/mShop/wearable/wear/shared/StampedMessage;->mId:Ljava/lang/String;

    .line 10
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/amazon/mShop/wearable/wear/shared/StampedMessage;->mData:[B

    .line 20
    iput-object p1, p0, Lcom/amazon/mShop/wearable/wear/shared/StampedMessage;->mId:Ljava/lang/String;

    .line 21
    iput-object p2, p0, Lcom/amazon/mShop/wearable/wear/shared/StampedMessage;->mData:[B

    .line 22
    return-void
.end method


# virtual methods
.method public dataAsString()Ljava/lang/String;
    .locals 3

    .prologue
    .line 25
    iget-object v0, p0, Lcom/amazon/mShop/wearable/wear/shared/StampedMessage;->mData:[B

    if-nez v0, :cond_0

    .line 26
    const/4 v0, 0x0

    .line 28
    :goto_0
    return-object v0

    :cond_0
    new-instance v0, Ljava/lang/String;

    iget-object v1, p0, Lcom/amazon/mShop/wearable/wear/shared/StampedMessage;->mData:[B

    sget-object v2, Lcom/amazon/mShop/wearable/wear/shared/StampedMessage;->UTF_8:Ljava/nio/charset/Charset;

    invoke-direct {v0, v1, v2}, Ljava/lang/String;-><init>([BLjava/nio/charset/Charset;)V

    goto :goto_0
.end method
