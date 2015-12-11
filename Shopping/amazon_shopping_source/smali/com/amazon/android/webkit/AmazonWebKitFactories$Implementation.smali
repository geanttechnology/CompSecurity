.class Lcom/amazon/android/webkit/AmazonWebKitFactories$Implementation;
.super Ljava/lang/Object;
.source "AmazonWebKitFactories.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/android/webkit/AmazonWebKitFactories;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "Implementation"
.end annotation


# static fields
.field static FACTORY:Lcom/amazon/android/webkit/AmazonWebKitFactory;


# direct methods
.method static constructor <clinit>()V
    .locals 12

    .prologue
    const/4 v11, 0x1

    .line 55
    const/4 v3, 0x0

    .line 58
    .local v3, "factory":Ljava/lang/String;
    :try_start_0
    # invokes: Lcom/amazon/android/webkit/AmazonWebKitFactories;->getExternalFactoryName()Ljava/lang/String;
    invoke-static {}, Lcom/amazon/android/webkit/AmazonWebKitFactories;->access$000()Ljava/lang/String;

    move-result-object v3

    .line 59
    if-eqz v3, :cond_0

    invoke-virtual {v3}, Ljava/lang/String;->length()I

    move-result v8

    if-nez v8, :cond_1

    .line 60
    :cond_0
    # getter for: Lcom/amazon/android/webkit/AmazonWebKitFactories;->defaultFactory:Ljava/lang/String;
    invoke-static {}, Lcom/amazon/android/webkit/AmazonWebKitFactories;->access$100()Ljava/lang/String;

    move-result-object v3

    .line 62
    :cond_1
    if-eqz v3, :cond_2

    invoke-virtual {v3}, Ljava/lang/String;->length()I

    move-result v8

    if-eqz v8, :cond_2

    invoke-static {v3}, Lcom/amazon/android/webkit/AmazonWebKitFactories$Implementation;->createWebKitFactoryByName(Ljava/lang/String;)Z

    move-result v8

    if-nez v8, :cond_3

    .line 63
    :cond_2
    const/4 v8, 0x2

    new-array v2, v8, [Ljava/lang/String;

    const/4 v8, 0x0

    const-string/jumbo v9, "com.amazon.android.webkit.embedded.EmbeddedWebKitFactory"

    aput-object v9, v2, v8

    const/4 v8, 0x1

    const-string/jumbo v9, "com.amazon.android.webkit.android.AndroidWebKitFactory"

    aput-object v9, v2, v8

    .line 64
    .local v2, "factories":[Ljava/lang/String;
    move-object v0, v2

    .local v0, "arr$":[Ljava/lang/String;
    array-length v6, v0

    .local v6, "len$":I
    const/4 v5, 0x0

    .local v5, "i$":I
    :goto_0
    if-ge v5, v6, :cond_3

    aget-object v7, v0, v5

    .line 65
    .local v7, "s":Ljava/lang/String;
    invoke-static {v7}, Lcom/amazon/android/webkit/AmazonWebKitFactories$Implementation;->createWebKitFactoryByName(Ljava/lang/String;)Z
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result v8

    if-eqz v8, :cond_4

    .line 66
    move-object v3, v7

    .line 75
    .end local v0    # "arr$":[Ljava/lang/String;
    .end local v2    # "factories":[Ljava/lang/String;
    .end local v5    # "i$":I
    .end local v6    # "len$":I
    .end local v7    # "s":Ljava/lang/String;
    :cond_3
    sget-object v8, Lcom/amazon/android/webkit/AmazonWebKitFactories$Implementation;->FACTORY:Lcom/amazon/android/webkit/AmazonWebKitFactory;

    if-nez v8, :cond_5

    .line 76
    new-instance v8, Ljava/lang/RuntimeException;

    const-string/jumbo v9, "Unable to initialize webkit factory"

    invoke-direct {v8, v9}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    throw v8

    .line 64
    .restart local v0    # "arr$":[Ljava/lang/String;
    .restart local v2    # "factories":[Ljava/lang/String;
    .restart local v5    # "i$":I
    .restart local v6    # "len$":I
    .restart local v7    # "s":Ljava/lang/String;
    :cond_4
    add-int/lit8 v5, v5, 0x1

    goto :goto_0

    .line 71
    .end local v0    # "arr$":[Ljava/lang/String;
    .end local v2    # "factories":[Ljava/lang/String;
    .end local v5    # "i$":I
    .end local v6    # "len$":I
    .end local v7    # "s":Ljava/lang/String;
    :catch_0
    move-exception v1

    .line 72
    .local v1, "e":Ljava/lang/Exception;
    new-instance v8, Ljava/lang/RuntimeException;

    const-string/jumbo v9, "Unable to initialize webkit factory"

    invoke-direct {v8, v9, v1}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    throw v8

    .line 79
    .end local v1    # "e":Ljava/lang/Exception;
    :cond_5
    # invokes: Lcom/amazon/android/webkit/AmazonWebKitFactories;->detectApiLevelForFactory(Ljava/lang/String;)I
    invoke-static {v3}, Lcom/amazon/android/webkit/AmazonWebKitFactories;->access$200(Ljava/lang/String;)I

    move-result v4

    .line 80
    .local v4, "factoryApiLevel":I
    # getter for: Lcom/amazon/android/webkit/AmazonWebKitFactories;->TAG:Ljava/lang/String;
    invoke-static {}, Lcom/amazon/android/webkit/AmazonWebKitFactories;->access$300()Ljava/lang/String;

    move-result-object v8

    new-instance v9, Ljava/lang/StringBuilder;

    invoke-direct {v9}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v10, "Client API Level:4 Factory API Level:"

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9, v4}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v9

    invoke-static {v8, v9}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 82
    const/4 v8, -0x1

    if-ne v4, v8, :cond_6

    .line 83
    new-instance v8, Ljava/lang/RuntimeException;

    const-string/jumbo v9, "Unable to detect factory api level"

    invoke-direct {v8, v9}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    throw v8

    .line 86
    :cond_6
    # setter for: Lcom/amazon/android/webkit/AmazonWebKitFactories;->defaultFactoryApiLevelCache:I
    invoke-static {v4}, Lcom/amazon/android/webkit/AmazonWebKitFactories;->access$402(I)I

    .line 91
    # getter for: Lcom/amazon/android/webkit/AmazonWebKitFactories;->defaultFactoryApiLevelCache:I
    invoke-static {}, Lcom/amazon/android/webkit/AmazonWebKitFactories;->access$400()I

    move-result v8

    if-le v8, v11, :cond_7

    .line 94
    sget-object v8, Lcom/amazon/android/webkit/AmazonWebKitFactories$Implementation;->FACTORY:Lcom/amazon/android/webkit/AmazonWebKitFactory;

    # getter for: Lcom/amazon/android/webkit/AmazonWebKitFactories;->defaultFactoryApiLevelCache:I
    invoke-static {}, Lcom/amazon/android/webkit/AmazonWebKitFactories;->access$400()I

    move-result v9

    const/4 v10, 0x4

    invoke-static {v9, v10}, Ljava/lang/Math;->min(II)I

    move-result v9

    invoke-virtual {v8, v9}, Lcom/amazon/android/webkit/AmazonWebKitFactory;->setTargetApiLevel(I)V

    .line 97
    :cond_7
    return-void
.end method

.method private constructor <init>()V
    .locals 0

    .prologue
    .line 51
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method private static createWebKitFactoryByName(Ljava/lang/String;)Z
    .locals 4
    .param p0, "factory"    # Ljava/lang/String;

    .prologue
    .line 101
    :try_start_0
    invoke-static {p0}, Ljava/lang/Class;->forName(Ljava/lang/String;)Ljava/lang/Class;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Class;->newInstance()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/amazon/android/webkit/AmazonWebKitFactory;

    sput-object v1, Lcom/amazon/android/webkit/AmazonWebKitFactories$Implementation;->FACTORY:Lcom/amazon/android/webkit/AmazonWebKitFactory;

    .line 102
    # getter for: Lcom/amazon/android/webkit/AmazonWebKitFactories;->TAG:Ljava/lang/String;
    invoke-static {}, Lcom/amazon/android/webkit/AmazonWebKitFactories;->access$300()Ljava/lang/String;

    move-result-object v1

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v3, "Successfully create WebKitFactory by name: "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 108
    const/4 v1, 0x1

    :goto_0
    return v1

    .line 104
    :catch_0
    move-exception v0

    .line 105
    .local v0, "e":Ljava/lang/Exception;
    # getter for: Lcom/amazon/android/webkit/AmazonWebKitFactories;->TAG:Ljava/lang/String;
    invoke-static {}, Lcom/amazon/android/webkit/AmazonWebKitFactories;->access$300()Ljava/lang/String;

    move-result-object v1

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v3, "Create WebKitFactoryByName failed: "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    .line 106
    const/4 v1, 0x0

    goto :goto_0
.end method
