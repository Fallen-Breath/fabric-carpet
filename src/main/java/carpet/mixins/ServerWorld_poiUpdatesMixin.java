package carpet.mixins;

import carpet.CarpetSettings;
import net.minecraft.server.world.ServerWorld;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ServerWorld.class)
public class ServerWorld_poiUpdatesMixin
{
    @Inject(method = "onBlockChanged", at = @At("HEAD"), cancellable = true)
    void disablePOIUpdates(CallbackInfo ci)
    {
        if (!CarpetSettings.poiUpdates)
        {
            ci.cancel();
        }
    }
}
