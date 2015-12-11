.class Lcom/amazon/identity/auth/device/storage/PreMergeDeviceCookieDataStore$1;
.super Ljava/lang/Object;
.source "PreMergeDeviceCookieDataStore.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/identity/auth/device/storage/PreMergeDeviceCookieDataStore;->getCookies(Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/identity/auth/device/storage/PreMergeDeviceCookieDataStore;

.field final synthetic val$copyOfCookies:Ljava/util/List;

.field final synthetic val$directedId:Ljava/lang/String;

.field final synthetic val$domain:Ljava/lang/String;


# direct methods
.method constructor <init>(Lcom/amazon/identity/auth/device/storage/PreMergeDeviceCookieDataStore;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V
    .locals 0

    .prologue
    .line 53
    iput-object p1, p0, Lcom/amazon/identity/auth/device/storage/PreMergeDeviceCookieDataStore$1;->this$0:Lcom/amazon/identity/auth/device/storage/PreMergeDeviceCookieDataStore;

    iput-object p2, p0, Lcom/amazon/identity/auth/device/storage/PreMergeDeviceCookieDataStore$1;->val$directedId:Ljava/lang/String;

    iput-object p3, p0, Lcom/amazon/identity/auth/device/storage/PreMergeDeviceCookieDataStore$1;->val$domain:Ljava/lang/String;

    iput-object p4, p0, Lcom/amazon/identity/auth/device/storage/PreMergeDeviceCookieDataStore$1;->val$copyOfCookies:Ljava/util/List;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 4

    .prologue
    .line 57
    iget-object v0, p0, Lcom/amazon/identity/auth/device/storage/PreMergeDeviceCookieDataStore$1;->this$0:Lcom/amazon/identity/auth/device/storage/PreMergeDeviceCookieDataStore;

    iget-object v1, p0, Lcom/amazon/identity/auth/device/storage/PreMergeDeviceCookieDataStore$1;->val$directedId:Ljava/lang/String;

    iget-object v2, p0, Lcom/amazon/identity/auth/device/storage/PreMergeDeviceCookieDataStore$1;->val$domain:Ljava/lang/String;

    iget-object v3, p0, Lcom/amazon/identity/auth/device/storage/PreMergeDeviceCookieDataStore$1;->val$copyOfCookies:Ljava/util/List;

    invoke-virtual {v0, v1, v2, v3}, Lcom/amazon/identity/auth/device/storage/PreMergeDeviceCookieDataStore;->setCookies(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V

    .line 58
    return-void
.end method
