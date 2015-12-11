.class Lcom/amazon/device/crashmanager/CrashDescriptorStorageUtil$LRUCache;
.super Ljava/util/LinkedHashMap;
.source "CrashDescriptorStorageUtil.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/device/crashmanager/CrashDescriptorStorageUtil;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "LRUCache"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "<K:",
        "Ljava/lang/Object;",
        "V:",
        "Ljava/lang/Object;",
        ">",
        "Ljava/util/LinkedHashMap",
        "<TK;TV;>;"
    }
.end annotation


# instance fields
.field private final mMaxCapacity:I

.field final synthetic this$0:Lcom/amazon/device/crashmanager/CrashDescriptorStorageUtil;


# direct methods
.method public constructor <init>(Lcom/amazon/device/crashmanager/CrashDescriptorStorageUtil;I)V
    .locals 3
    .param p2, "maxCapacity"    # I

    .prologue
    .line 345
    .local p0, "this":Lcom/amazon/device/crashmanager/CrashDescriptorStorageUtil$LRUCache;, "Lcom/amazon/device/crashmanager/CrashDescriptorStorageUtil$LRUCache<TK;TV;>;"
    iput-object p1, p0, Lcom/amazon/device/crashmanager/CrashDescriptorStorageUtil$LRUCache;->this$0:Lcom/amazon/device/crashmanager/CrashDescriptorStorageUtil;

    .line 346
    add-int/lit8 v0, p2, 0x1

    const/high16 v1, 0x3f400000    # 0.75f

    const/4 v2, 0x1

    invoke-direct {p0, v0, v1, v2}, Ljava/util/LinkedHashMap;-><init>(IFZ)V

    .line 347
    iput p2, p0, Lcom/amazon/device/crashmanager/CrashDescriptorStorageUtil$LRUCache;->mMaxCapacity:I

    .line 348
    return-void
.end method


# virtual methods
.method protected removeEldestEntry(Ljava/util/Map$Entry;)Z
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Map$Entry",
            "<TK;TV;>;)Z"
        }
    .end annotation

    .prologue
    .line 352
    .local p0, "this":Lcom/amazon/device/crashmanager/CrashDescriptorStorageUtil$LRUCache;, "Lcom/amazon/device/crashmanager/CrashDescriptorStorageUtil$LRUCache<TK;TV;>;"
    .local p1, "eldest":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<TK;TV;>;"
    invoke-virtual {p0}, Lcom/amazon/device/crashmanager/CrashDescriptorStorageUtil$LRUCache;->size()I

    move-result v0

    iget v1, p0, Lcom/amazon/device/crashmanager/CrashDescriptorStorageUtil$LRUCache;->mMaxCapacity:I

    if-le v0, v1, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method
