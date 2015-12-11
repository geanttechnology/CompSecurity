.class public interface abstract Lcom/amazon/identity/auth/accounts/MultipleAccountPlugin;
.super Ljava/lang/Object;
.source "MultipleAccountPlugin.java"


# virtual methods
.method public abstract addDataOnAddAccount(Ljava/lang/String;Landroid/os/Bundle;Landroid/os/Bundle;)V
.end method

.method public abstract deregisterAllAccountsOnAccountRemoval(Ljava/lang/String;)Z
.end method

.method public abstract getAccountHierarchy(Ljava/lang/String;I)[Lcom/amazon/identity/auth/device/api/MultipleAccountManager$AccountMappingType;
.end method

.method public abstract getVisibleUser()Ljava/lang/String;
.end method

.method public abstract notifyToolbarOfUserChanged(Ljava/lang/String;Landroid/content/Intent;Ljava/lang/String;)V
.end method

.method public abstract sendAccountRemovalBroadcast(Ljava/lang/String;Ljava/util/Set;Landroid/content/Intent;Ljava/lang/String;)V
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/util/Set",
            "<",
            "Ljava/lang/Integer;",
            ">;",
            "Landroid/content/Intent;",
            "Ljava/lang/String;",
            ")V"
        }
    .end annotation
.end method

.method public abstract sendBroadcast(Ljava/lang/String;Landroid/content/Intent;Ljava/lang/String;)V
.end method

.method public abstract sendBroadcastToMainUser(Ljava/lang/String;Landroid/content/Intent;Ljava/lang/String;)V
.end method
